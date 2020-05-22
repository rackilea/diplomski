@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    TimerTask task = new RepeatingTask();
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(task, 0, 3000);
}

public class RepeatingTask extends TimerTask {

 private int len = 0; 

 private byte[] input = new byte[len];


 public RepeatingTask() {
     //try {
        Log.e(LOG_TAG, "Before inputJSON String");
        //inputJSON = dataInputStream.readUTF();
        //URL url = new URL("tcp://23.23.175.213:1337");
        //inputJSON = dataInputStream.readUTF();
        //inputstrrd = new InputStreamReader(socket.getInputStream());
        String hello = "hello world";
        //String inputJSON = getStringFromBuffer(new InputStreamReader(socket.getInputStream()));

        //Convert 
        Log.e(LOG_TAG, "After inputJSON String:" + inputJSON); 
     /*}
     catch (UnknownHostException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
     }*/

     //LOOK HERE FIRST  
     //inputJSON is what is received back from the server - Take the inputJSON 
     //String and use regular expressions HERE to remove all the other characters in the 
     //string except the payload JSON.
     //refreshViewModels(inputJSON);
 }

 @Override
 public void run() { 
      try {
          Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON");
          //outputstrwr.write(outputJSONserv);  //UNCOMMENT IF NEED TO SEND DATA TO GET JSON BACK
          //inputJSON = ConvertByteArrayToString(getBytesFromInputStream(inputStr));
          inputJSON = ConvertByteArrayToString(getFileBytes(inputStr));
      } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
      }

      Log.e(LOG_TAG, "IN REPEATINGTHREAD-INPUTJSON2:" + inputJSON);
      refreshViewModels(inputJSON);
 }