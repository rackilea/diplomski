public class MainActivity extends Activity {

 private Connection serverConnection;
 private ArrayList<String> listItems = new ArrayList<String>();
 private ArrayAdapter<String> adapter;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
        ListView listview = (ListView) findViewById(R.id.lv);
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, 
                        listItems);
        listview.setAdapter(adapter);
     // use a button and on button click start the thread.

Thread connectThread = new Thread(new Runnable(){
    public void run(){
        serverConnection = new Connection(MainActivity.this);
        serverConnection.run();
    }
});
connectThread.start();
}

public void displayMessage(String string) {
listItems.add(string);
adapter.notifyDataSetChanged();
}
class Connection extends Thread {

private Socket client;
private ObjectOutputStream output;
private ObjectInputStream input;
private MainActivity mainActivity;
private String message;

public Connection(MainActivity mainActivity) {
this.mainActivity = mainActivity;
try {
    client = new Socket("192.168.1.105", 50499);
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            displayMessage("Connected to: "
                   );
        }
    });

    output = new ObjectOutputStream(client.getOutputStream());
    output.flush();
    input = new ObjectInputStream(client.getInputStream());
} catch (IOException e) {
    e.printStackTrace();
}
}

 public void run() {
 for (;;) {
    try {
          message = (String) input.readObject();
          runOnUiThread(new Runnable() {
              @Override
              public void run() {
                displayMessage(message);
              }
          });



    } catch (OptionalDataException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
}
}
}