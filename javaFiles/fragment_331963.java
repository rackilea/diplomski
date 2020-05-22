class SayHello extends TimerTask {
    public void run() {
       System.out.println("Hello World!"); 
    }
 }

 // And From your main() method or any other method
 Timer timer = new Timer();
 timer.schedule(new SayHello(), 0, 5000);