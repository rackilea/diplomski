static volatile int c=0;
public static void main(String[] args) {
    Thread t=new Thread(new Runnable() {
        @Override
        public void run() {
            while(!Thread.interrupted())
                c=(c+1)%3;
        }
    });
    t.start();
    int some=10;
    while(some>0)
        if(c==0 && c==1 && c==2){
            System.out.println("Bingo!");
            some--;
        }
    t.interrupt();
}