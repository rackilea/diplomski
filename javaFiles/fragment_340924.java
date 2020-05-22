public void MyActivity extends Activity{

public void onCreate(Bundle savedInstanceState){

     new  MyAsyncTaskClass().execute();
}

//internal class
public class MyAsyncTaskClass extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(Void... arg0) {
            Properties properties = new Properties();
        properties.setProperty("mail.imaps.host", "imap.gmail.com"); 
            properties.setProperty("mail.imaps.auth", "true"); 
            properties.setProperty("mail.imaps.debug", "true"); 
            properties.setProperty("mail.imaps.port", "993");
            properties.setProperty("mail.store.protocol", "imaps");
        session = Session.getInstance(properties);

            store = session.getStore("imaps");
            store.connect("imap.gmail.com", 993, userName, password);
            return null;
      }

    }
}