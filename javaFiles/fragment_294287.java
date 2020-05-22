final Context context;
public class kelas1 extends Activity {

   public kelas1(Context context)
    {
       this.context = context;
       call_thread();   
    }

public void call_thread(){
        new Thread(new Runnable(){
         public void run() {
            while (true) {
                charsRead = in.read(buffer);
                if (charsRead != 1) {
                    String message = new String(buffer).substring(0, charsRead).replace(System.getProperty("line.separator"),"");
                    Log.d("wew", message);

                    // this is my problem
                        sms.inbox(this.context,localDataOutputStream);
                }
              }
           }).start();

        }
    }