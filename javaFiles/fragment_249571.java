public class MyMain {


    // private Logger log = LoggerFactory.getLogger(MyMain.class);

     private AbstractLogger l1= new LoggerOne(this.getClass());
     private AbstractLogger l2= new LoggerTwo(this.getClass());
     private AbstractLogger l3= new LoggerThree(this.getClass());


    public void run()
    {

            l1.log("log 1");

             long t1 = System.currentTimeMillis();

             try {
                    Thread.sleep(1000);                 //1000 milliseconds is one second.
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

             long t2 = System.currentTimeMillis();
             l2.log("log 2");
             l3.log("Foo time taken:" + (t2-t1)/1000); 

    }

    public static void main(String[] args) {

        MyMain me = new MyMain();
        me.run();

    }

}