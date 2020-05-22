public class ThreadsStop {

    static String n="";

    class Printer extends Thread{

        @Override
        public void run() {

            while(!n.equals(null)){

                try {
                    Thread.sleep(1000);

                    if(n.trim().equals("1"))
                        System.out.println("Learning..");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }

    }

    class Starter extends Thread{

        @Override
        public void run() {

            Scanner reader = new Scanner(System.in);

            while(true){
                System.out.println("1 = ON \n 0 = OFF");
                n= reader.nextLine();
            }
        }

    }

    public static void main(String[] args) {

        new ThreadsStop().start();

    }

    private void start() {

        new Starter().start();
        new Printer().start();

    }

}