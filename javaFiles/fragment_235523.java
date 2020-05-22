public class NetworkConn {
    static Boolean isConnected = false;
    static String mTAG = "NETWORK ACTIVITY - Webclass Class";
    public static Boolean grabConnectionStatus(Context context){
        checkConnectionStatus(context);
        return isConnected;
    }
    // checkConnectionStatus method
    public static void checkConnectionStatus(Context context) {
        // Obtaining context system service /Connectivity_Service
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // Obtaining active network info for created connectivitymanager instance
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // checking if networkInfo is null or not
        if (networkInfo != null) {
            // checking if network info is connected
            if (networkInfo.isConnected()) {
                // logging connection type if connected, and networkInfo is not null
                Log.i(mTAG, "connection type: " + networkInfo.getTypeName());
                // setting isConnected to true if connected and networkInfo is not null
                isConnected = true;
            }
        }
    }
    // getURLResponse method
    public static String getURLResponse(String url) {
        // Resetting response var by setting it to equal nothing.
        String response = "";
        try {
            // Initializing URLConnection
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            // Setting created bufferedinputstring to connection input stream
            BufferedInputStream bis = new BufferedInputStream(
                    connection.getInputStream());
            // Setting contextByte
            byte[] contextByte = new byte[1024];
            // Setting int bytesRead
            int bytesRead = 0;
            // Setting StringBuffer entitled responseBuffer to new StringBuffer
            StringBuffer responseBuffer = new StringBuffer();
            // While conditional to check while bytesRead is
            while ((bytesRead = bis.read(contextByte)) != -1) {
                response = new String(contextByte, 0, bytesRead);
                responseBuffer.append(response);
            }
            response = responseBuffer.toString();
            Log.i(mTAG, response);

        } catch (IOException e) {

            response = "Something happened, no info returned!";
            Log.e(mTAG, "Something happened, no info returned!", e);
        }
        return response;
    }
}