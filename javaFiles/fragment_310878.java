public class GDBpipeWriter extends Thread{

        public void run(){
        Process p = null;
        try {
        p = Runtime.getRuntime().exec("gdb a.out --interpreter=console");
       new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
       new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
        PrintWriter stdin = new PrintWriter(p.getOutputStream());

        stdin.flush();
        stdin.println("break 4");
        stdin.flush();
        stdin.println("break 10");
        stdin.flush();
        stdin.println("run");
        stdin.flush();

        /// write any other commands you want here
       // stdin.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }


class SyncPipe implements Runnable
{
public SyncPipe(InputStream istrm, OutputStream ostrm) {
      istrm_ = istrm;
      ostrm_ = ostrm;
  }
  public void run() {
      try
      {
          final byte[] buffer = new byte[1024];
          for (int length = 0; (length = istrm_.read(buffer)) != -1; )
          {
              ostrm_.write(buffer, 0, length);
          }

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
  }
  private final OutputStream ostrm_;
  private final InputStream istrm_;
}