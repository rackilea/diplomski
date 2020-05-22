final String ASR_URL="http:..... ";
public class curlAudioToWatson extends AsyncTask<String, Void, String> {
    String asrJsonString="";
    @Override
    protected String doInBackground(String... params) {
        String result = "";
        try {
            loge("**** UPLOADING .WAV to ASR...");
            URL obj = new URL(ASR_URL);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestProperty("X-Arg", "AccessKey=3fvfg985-2830-07ce-e998-4e74df");
            conn.setRequestProperty("Content-Type", "audio/wav");
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            String wavpath=Environment.getExternalStorageDirectory().getAbsolutePath()+"/my AppFolder/"+StorageUtils.AUDIO_FILE_NAME+".wav"; //audio.wav";
            File wavfile = new File(wavpath);
            boolean success = true;
            if (wavfile.exists()) {
                loge("**** audio.wav DETECTED: "+wavfile);
            }
            else{
                loge("**** audio.wav MISSING: " +wavfile);
            }

            String charset="UTF-8";
            String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.
            String CRLF = "\r\n"; // Line separator required by multipart/form-data.

            OutputStream output=null;
            PrintWriter writer=null;
            try {
                output = conn.getOutputStream();
                writer = new PrintWriter(new OutputStreamWriter(output, charset), true);
                byte [] music=new byte[(int) wavfile.length()];//size & length of the file
                InputStream             is  = new FileInputStream       (wavfile);
                BufferedInputStream bis = new BufferedInputStream   (is, 16000);
                DataInputStream dis = new DataInputStream       (bis);      //  Create a DataInputStream to read the audio data from the saved file
                int i = 0;
                copyStream(dis,output);
            }
            catch(Exception e){

            }

            conn.connect();

            int responseCode = conn.getResponseCode();
            logy("POST Response Code : " + responseCode + " , MSG: " + conn.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) { //success
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                loge("***ASR RESULT: " + response.toString());


                JSONArray jresponse=new JSONObject(response.toString()).getJSONObject("Recognition").getJSONArray("NBest");
                asrJsonString=jresponse.toString();

                for(int i = 0 ; i < jresponse.length(); i++){
                    JSONObject jsoni=jresponse.getJSONObject(i);
                    if(jsoni.has("ResultText")){
                        String asrResult=jsoni.getString("ResultText");
                        //ActionManager.getInstance().addDebugMessage("ASR Result: "+asrResult);
                        loge("*** Result Text: "+asrResult);
                        result = asrResult;
                    }
                }
                loge("***ASR RESULT: " + jresponse.toString());

            } else {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                loge("POST FAILED: " + response.toString());
                result = "";
            }
        } catch (Exception e) {
            logy("HTTP Exception: " + e.getLocalizedMessage());
        }
        return result; //"Failed to fetch data!";
    }

    @Override
    protected void onPostExecute(String result) {
        if(!result.equals("")){
            logy("onPostEXECUTE SUCCESS, consuming result");
            sendTextInputFromUser(result);
            ActionManager.getInstance().addDebugMessage("***ASR RESULT: "+asrJsonString);
            runOnUiThread(new Runnable() {
                @Override 
                public void run() { 

               } 
           });
        }else{
            logy("onPostEXECUTE FAILED");
        }
    }
}


public void copyStream( InputStream is, OutputStream os) {
    final int buffer_size = 4096;
    try {

        byte[] bytes = new byte[buffer_size];
        int k=-1;
        double prog=0;
        while ((k = is.read(bytes, 0, bytes.length)) > -1) {
            if(k != -1) {
                os.write(bytes, 0, k);
                prog=prog+k;
                double progress = ((long) prog)/1000;///size;
                loge("UPLOADING: "+progress+" kB");
            }
        }
        os.flush();
        is.close();
        os.close();
    } catch (Exception ex) {
        loge("File to Network Stream Copy error "+ex);
    }
}