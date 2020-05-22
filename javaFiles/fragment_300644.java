class MyFrame extends JFrame{
   private MyThread otherThread;

   public MyFrame(MyThread otherThread){
       super("MyFrame");

       this.otherThread=otherThread;
   }

   ...
   public void dispose(){
       otherThread.interruptMyThread();
       super.dispose();
   }
}