public class RestPostThread extends Thread  {

public Handler mHandler,uiHandler;


public RestPostThread(Handler handler) {
    uiHandler = handler;
}

@Override
public void run(){
    Looper.prepare();
    mHandler = new Handler() {
        public void handleMessage(Message msg) {
                try {
                    //Thread.sleep(1000);
                    URL url = new URL(msg.obj.toString());
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    String input = "<Instruction><type>put_me_in</type><room>Room 1</room></Instruction>";

                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();

                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                        //  throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
                    }
                    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                    String output;
                    String aux = new String();
                    while ((output = br.readLine()) != null) {
                        aux = aux + output;
                    }
                    conn.disconnect();
                    Message msg2 = uiHandler.obtainMessage();
                    msg2.obj = aux;
                    uiHandler.sendMessage(msg2);
                }catch(MalformedURLException e){
                    e.printStackTrace();
                }catch(IOException e){
                    e.printStackTrace();
                }catch(Exception e){
                }
            }
    };
    Looper.loop();
}


public Handler getThreadHandler() {
    return this.mHandler;
}