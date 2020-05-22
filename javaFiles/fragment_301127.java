package newbully;

public class NewBully {

    public static void main(String[] args) {
        int total_processes = 6;
        RunningThread[] t = new RunningThread[total_processes];
        for (int i = 0; i < total_processes; i++) {
            t[i] = new RunningThread(new Process(i+1, i+1), total_processes);//passing process id, priority, total no. of processes to running thread
        }
        try {
            Election.initialElection(t);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        for (int i = 0; i < total_processes; i++) {
            new Thread(t[i]).start();//start every thread
        }
    }
}

package newbully;

import java.util.concurrent.locks.ReentrantLock;

public class Election {

    public static ReentrantLock pingLock = new ReentrantLock();
    public static ReentrantLock electionLock = new ReentrantLock();
    private static boolean electionFlag = false; //By default no election is going on
    private static boolean pingFlag = true; //By default I am allowed to ping 
    public static Process electionDetector;

    public static Process getElectionDetector() {
        return electionDetector;
    }

    public static void setElectionDetector(Process electionDetector) {
        Election.electionDetector = electionDetector;
    }

    public static boolean isPingFlag() {
        return pingFlag;
    }

    public static void setPingFlag(boolean pingFlag) {
        Election.pingFlag = pingFlag;
    }

    public static boolean isElectionFlag() {
        return electionFlag;
    }

    public static void setElectionFlag(boolean electionFlag) {
        Election.electionFlag = electionFlag;
    }

    public static void initialElection(RunningThread[] t) {
        Process temp = new Process(-1, -1);
        for (int i = 0; i < t.length; i++) {
            if (temp.getPriority() < t[i].getProcess().getPriority()) {
                temp = t[i].getProcess();
            }
        }
        t[temp.pid - 1].getProcess().CoOrdinatorFlag = true;
    }
}

package newbully;

import java.util.*;
import java.io.*;
import java.net.*;

public class RunningThread implements Runnable {

    private Process process;
    private int total_processes;
    private static boolean messageFlag[];
    ServerSocket[] sock;
    Random r;

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public RunningThread(Process process, int total_processes) {
        this.process = process;
        this.total_processes = total_processes;
        this.r = new Random();
        this.sock = new ServerSocket[total_processes];
        RunningThread.messageFlag = new boolean[total_processes];
        for (int i = 0; i < total_processes; i++) {
            RunningThread.messageFlag[i] = false;
        }
    }

    synchronized private void recovery() {
        while (Election.isElectionFlag());//if election is going on then wait
        System.out.println("Process[" + this.process.getPid() + "]: -> Recovered from Crash");
        //Find current co-ordinator.         
        try {
            Election.pingLock.lock();
            Election.setPingFlag(false);
            Socket outgoing = new Socket(InetAddress.getLocalHost(), 12345);
            Scanner scan = new Scanner(outgoing.getInputStream());
            PrintWriter out = new PrintWriter(outgoing.getOutputStream(), true);
            System.out.println("Process[" + this.process.getPid() + "]:-> Who is the co-ordinator?");
            out.println("Who is the co-ordinator?");
            out.flush();
            String pid = scan.nextLine();
            String priority = scan.nextLine();
            if (this.process.getPriority() > Integer.parseInt(priority)) { //Bully Condition
                out.println("Resign");
                out.flush();
                System.out.println("Process[" + this.process.getPid() + "]: Resign -> Process[" + pid + "]");
                String resignStatus = scan.nextLine();
                if (resignStatus.equals("Successfully Resigned")) {
                    this.process.setCoOrdinatorFlag(true);
                    sock[this.process.getPid() - 1] = new ServerSocket(10000 + this.process.getPid());
                    System.out.println("Process[" + this.process.getPid() + "]: -> Bullyed current co-ordinator Process[" + pid + "]");
                }
            } else {
                out.println("Don't Resign");
                out.flush();
            }
            Election.pingLock.unlock();
            return;

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    synchronized private void pingCoOrdinator() {
        try {
            Election.pingLock.lock();
            if (Election.isPingFlag()) {
                System.out.println("Process[" + this.process.getPid() + "]: Are you alive?");
                Socket outgoing = new Socket(InetAddress.getLocalHost(), 12345);
                outgoing.close();
            }
        } catch (Exception ex) {
            Election.setPingFlag(false);
            Election.setElectionFlag(true);
            Election.setElectionDetector(this.process);
            //Initiate Election
            System.out.println("process[" + this.process.getPid() + "]: -> Co-Ordinator is down\n" + "process[" + this.process.getPid() + "]: ->Initiating Election");
        } finally {
            Election.pingLock.unlock();
        }
    }

    private void executeJob() {
        int temp = r.nextInt(20);
        for (int i = 0; i <= temp; i++) {
            try {
                Thread.sleep((temp + 1) * 100);
            } catch (InterruptedException e) {
                System.out.println("Error Executing Thread:" + process.getPid());
                System.out.println(e.getMessage());
            }
        }
    }

    synchronized private boolean sendMessage() {
        boolean response = false;
        try {
            Election.electionLock.lock();
            if (Election.isElectionFlag() && !RunningThread.isMessageFlag(this.process.getPid() - 1) && this.process.priority >= Election.getElectionDetector().getPriority()) {

                for (int i = this.process.getPid() + 1; i <= this.total_processes; i++) {
                    try {
                        Socket electionMessage = new Socket(InetAddress.getLocalHost(), 10000 + i);
                        System.out.println("Process[" + this.process.getPid() + "] -> Process[" + i + "]  responded to election message successfully");
                        electionMessage.close();
                        response = true;
                    } catch (IOException ex) {
                        System.out.println("Process[" + this.process.getPid() + "] -> Process[" + i + "] did not respond to election message");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                this.setMessageFlag(true, this.process.getPid() - 1);//My message sending is done
                Election.electionLock.unlock();
                return response;
            } else {
                throw new Exception();
            }
        } catch (Exception ex1) {
            Election.electionLock.unlock();
            return true;
        }
    }

    public static boolean isMessageFlag(int index) {
        return RunningThread.messageFlag[index];
    }

    public static void setMessageFlag(boolean messageFlag, int index) {
        RunningThread.messageFlag[index] = messageFlag;
    }

    synchronized private void serve() {
        try {
            boolean done = false;
            Socket incoming = null;
            ServerSocket s = new ServerSocket(12345);
            Election.setPingFlag(true);
            int temp = this.r.nextInt(5) + 5;// min 5 requests and max 10 requests
            for (int counter = 0; counter < temp; counter++) {
                incoming = s.accept();
                if (Election.isPingFlag()) {
                    System.out.println("Process[" + this.process.getPid() + "]:Yes");
                }
                Scanner scan = new Scanner(incoming.getInputStream());
                PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
                while (scan.hasNextLine() && !done) {
                    String line = scan.nextLine();
                    if (line.equals("Who is the co-ordinator?")) {
                        System.out.println("Process[" + this.process.getPid() + "]:-> " + this.process.getPid());
                        out.println(this.process.getPid());
                        out.flush();
                        out.println(this.process.getPriority());
                        out.flush();
                    } else if (line.equals("Resign")) {
                        this.process.setCoOrdinatorFlag(false);
                        out.println("Successfully Resigned");
                        out.flush();
                        incoming.close();
                        s.close();
                        System.out.println("Process[" + this.process.getPid() + "]:-> Successfully Resigned");
                        return;
                    } else if (line.equals("Don't Resign")) {
                        done = true;
                    }
                }
            }
            //after serving 5-10 requests go down for random time
            this.process.setCoOrdinatorFlag(false);
            this.process.setDownflag(true);
            try {
                incoming.close();
                s.close();
                sock[this.process.getPid() - 1].close();
                Thread.sleep(15000);//(this.r.nextInt(10) + 1) * 10000);//going down
                recovery();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            sock[this.process.getPid() - 1] = new ServerSocket(10000 + this.process.getPid());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        while (true) {
            if (process.isCoOrdinatorFlag()) {
                //serve other processes
                serve();
            } else {
                while (true) {
                    //Execute some task
                    executeJob();
                    //Ping the co-ordinator
                    pingCoOrdinator();
                    //Do Election
                    if (Election.isElectionFlag()) {
                        if (!sendMessage()) {//elect self as co-ordinator
                            Election.setElectionFlag(false);//Election is Done
                            System.out.println("New Co-Ordinator: Process[" + this.process.getPid() + "]");
                            this.process.setCoOrdinatorFlag(true);
                            for (int i = 0; i < total_processes; i++) {
                                RunningThread.setMessageFlag(false, i);
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}

package newbully;

public class Process {

    int pid;
    boolean downflag,CoOrdinatorFlag;

    public boolean isCoOrdinatorFlag() {
        return CoOrdinatorFlag;
    }

    public void setCoOrdinatorFlag(boolean isCoOrdinator) {
        this.CoOrdinatorFlag = isCoOrdinator;
    }
    int priority;

    public boolean isDownflag() {
        return downflag;
    }

    public void setDownflag(boolean downflag) {
        this.downflag = downflag;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Process() {
    }

    public Process(int pid, int priority) {
        this.pid = pid;
        this.downflag = false;
        this.priority = priority;
        this.CoOrdinatorFlag = false;
    }
}