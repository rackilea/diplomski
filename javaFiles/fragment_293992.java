public class Test{
  private int count=10;
  private Thread thread=new Thread(new Runnable(){
    @Override
    public void run(){
       System.out.println(count);
    }
  });
  public static void main(String []args){
      new Test().thread.start();  
   }
}