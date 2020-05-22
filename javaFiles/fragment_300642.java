class MyFrame extends JFrame{
   private Thread otherThread;

   public MyFrame(Thread otherThread){
       super("MyFrame");

       this.otherThread=otherThread;
   }

   ...
   public void dispose(){
       otherThread.interrupt();
       super.dispose();
   }
}