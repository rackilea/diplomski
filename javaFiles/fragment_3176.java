class Printer implements Runnable {

protected long MILLIS_PER_PAGE = 500;

private String name;
Queue queue;
boolean lock = false;

public Printer(String name, Queue queue) {
    this.name = name;
    this.queue = queue;
}

public String getPrinterName() {
    return name;
}

@Override
public void run() {
    System.out.println("["+getPrinterName()+"] Ligando...");
    while(true) {
        synchronized(this){
            if(queue.isEmpty()) {
                try {
                    System.out.println("["+getPrinterName()+"] Esperando por tabalho de impressão...");
                    lock = false;
                    notifyAll();
                    halt();
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else {
                lock = true;
                PrintJob pj = queue.removeFront();
                System.out.println("Imprimindo "+ pj.getJobName());
                try {
                    wait(pj.getNumberOfPages() * MILLIS_PER_PAGE);
                    System.out.println(pj.getJobName() + " ok.");
                } 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}

public void halt() throws InterruptedException {

    wait();

}

}
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Producer implements Runnable {

private String name;
Queue queue;

String job;
int pags;
String arquivo;

public Producer(String name, Queue queue, String arquivo) {
    this.name = name;
    this.queue = queue;
    this.arquivo = arquivo;
}

public String getProducerName() {
    return name;
}

@Override
public void run(){
    FileReader fin;

    try {
         fin = new FileReader(arquivo);
         Scanner src = new Scanner(fin);

         while (src.hasNext() ) {                    
         synchronized (PrinterApp.printer) {
                while (PrinterApp.printer.lock == true){
                    PrinterApp.printer.wait();
                }
                job = src.next();
                pags = src.nextInt();
                PrintJob p = new PrintJob(job, pags);

                queue.addBack(p);

                System.out.println("["+getProducerName()+"] produzindo arquivo " + job +", número de páginas: " + pags);
                PrinterApp.printer.notifyAll();
             }
             // don't wait here since your not waiting on a condition to change
             Thread.sleep(1000 + (int)Math.round((Math.random() * (5000 - 1000))));  

            }
            fin.close();
        }


        catch (FileNotFoundException e) {
            e.printStackTrace();

        } 
        catch (QueueException e) {

            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
}