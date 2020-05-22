import java.io.*;
public class foo{
  public static void main(String[] args) throws Exception{

    System.setIn(new InputStream() {
      InputStream in=System.in;
      @Override
      public int read() throws IOException {
        while(in.available()==0)try{Thread.sleep(100);}catch(Exception ex){}
        return in.read();
      }
    });

    Thread t = new Thread(
      new Runnable() {
        public void run() {
          try{
            System.out.println(System.in.read());
            while(true);
          }catch(Exception ex){}
        }
      }
    );
    t.setDaemon(true);
    t.start();
    Thread.sleep(1000);
  }
}