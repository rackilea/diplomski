public class HttpConnect {
    public HttpConnect(){

    }
    public void sendData(String jsonObject){
        try{
            URL url = new URL("http://www.alextanti.net/PHPDashboard/Backend/mobiledb_control.php");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(),"UTF-8"));
            output.write("json="+jsonObject);
            output.flush();
            output.close();
            Log.v("HTTPSENDER","WORKED");
            Log.v("HTTPSENDER",""+conn.getResponseCode());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}