import java.net.*;
public class foo{
  public static void main(String[] args) throws Exception{
    Thread t = new Thread(
      new Runnable() {
        public void run() {
          try{
            final ServerSocket srv=new ServerSocket(0);

            Thread t=new Thread(new Runnable(){
              public void run(){
                try{
                  Socket s=new Socket("localhost",srv.getLocalPort());
                  s.getInputStream().read();

                  while(true);
                }catch(Exception ex){}
            }});
            t.setDaemon(true);
            t.start();

            Socket s=srv.accept();

            s.getInputStream().read();

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