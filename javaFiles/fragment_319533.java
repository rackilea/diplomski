public class Client extends Thread{

    static int nbPlace=10;
    private final Semaphore sem = new Semaphore(1);

    public Client(String name){
        super(name);
    }
    public void run(){
        try {
            sem.acquire();
            decrementer(getName());
            sem.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    static void decrementer(String nomThread){
         nbPlace--; System.out.println("dec par "+nomThread+" ... nbplace="+nbPlace);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    Client [] t= new Client[5];
    for(int i=0;i<5;i++) t[i]=new  Client ("thread n° "+i);
    for (int i=0;i<5;i++) t[i].start();
    }
}