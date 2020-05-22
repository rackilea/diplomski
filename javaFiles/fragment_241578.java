public class MainActivity extends Activity implements Runnable{

EditText textUnten;
Button button;
ChatProzKlasse chat;
public static String puffer;
public static String messages;
public static TextView textMitte;
Thread thread;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textMitte = (TextView) findViewById (R.id.textMitteID);
    textUnten = (EditText) findViewById (R.id.textUntenID);
    button = (Button) findViewById(R.id.sendButton);

    messages = "";



    chat = new ChatProzKlasse();
    thread = new Thread(this);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            chat.client.send(textUnten.getText().toString());
            textUnten.setText("");



        }
    });
    thread.start();


}

public  void setTextMitte(){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            textMitte.setText(messages);
        }
        });


}
@Override
protected void onResume() {
    super.onResume();



}

@Override
public void run() {
    while(true) {
        setTextMitte();
        try {
            thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


}
public class ChatClient {

private Socket socket              = null;

private DataInputStream console    = null;
private DataOutputStream streamOut = null;
private DataInputStream streamIn = null;
public static boolean isconnected = false;

public ChatClient(String serverName, int serverPort){
    System.out.println("Verbindungsaufbau. Bitte warten ...");
    try{
        socket = new Socket(serverName, serverPort);
        Log.d("DEBUG", "Connected: " + socket);
        if(socket != null) {
            start();
        }
    }
    catch(UnknownHostException uhe){
        Log.d("DEBUG","Host unknown: " + uhe.getMessage());
    }
    catch(IOException ioe){
        Log.d("DEBUG","Unexpected exception: " + ioe.getMessage());
    }

}

public void start() throws IOException
{
    console   = new DataInputStream(System.in);
    streamOut = new DataOutputStream(socket.getOutputStream());
    isconnected = true;

}

public void stop(){
    try{
        if (console   != null)  console.close();
        if (streamOut != null)  streamOut.close();
        if (socket    != null)  socket.close();
    }
    catch(IOException ioe){
        System.out.println("Error closing ...");
    }
}
public void open() throws IOException{
    streamIn  = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
}
public void close() throws IOException{
    if (socket != null)    socket.close();
    if (console != null)  console.close();
}

public void send(String msg)
{
    try
    {
        if(msg != null) {
            streamOut.writeUTF(msg);
            streamOut.flush();
        }
    }
    catch(IOException ioe)
    {
        Log.d("DEBUG","Sending error: " + ioe.getMessage());
    }
}

public void recieve(){
    try{
        open();
        boolean done = false;

        while (!done){
            try{
                String line = streamIn.readUTF();
                if(!(line.equals(""))) {
                    MainActivity.messages =line;
                    MainActivity.puffer = line;
                }
                System.out.println(" " + line);
                done = line.equals(".bye");
            }
            catch(IOException ioe){
                done = true;
                ioe.printStackTrace();
            }
        }
        close();
    }
    catch(IOException ie){
        System.out.println("Acceptance Error: " + ie);
    }
}



}



public class ChatProzKlasse implements Runnable {
Thread thread;
ChatClient client;

public ChatProzKlasse(){
    thread = new Thread(this);
    thread.start();

}

@Override
public synchronized void run() {

    if(client == null) {
        try {
            System.out.println(" trying new Client");
            client = new ChatClient("192.168.1.111", 6668);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    if (client !=null){
        if(client != null && ChatClient.isconnected) {
            client.recieve();
        }
    }

}}