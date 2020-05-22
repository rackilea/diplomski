public class DaemonFolder extends Thread {

@SuppressWarnings("deprecation") // stop();
public static void main(String[] args) {
    System.out.println("Pulsar enter para finalizar");
    DaemonFolder daemonn= new DaemonFolder();
    Scanner finalize= new Scanner(System.in);
    finalize.nextLine();
    daemonn.stop();
    finalize.close();
    System.out.println("Programa finalizado!");
}

public DaemonFolder() {
    setDaemon(true); // Daemon threads in Java are like a service providers for other threads or objects running in the same process as the daemon thread
    start();
}

@Override
public void run() {
    while (true) {
        try {
            sleep(5000);
            if (new File("anonymous.txt").exists()){
            System.out.println("exists");
            //DO SOMETHING
            } else {
                System.out.println("not exists");
            }               
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
}