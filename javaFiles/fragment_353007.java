try 
{
    input = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
    String messageStr = "";
    while (!Thread.currentThread().isInterrupted() && (messageStr = input.readLine()) != null) 
    {
        updateMessages(messageStr, false);
    }
    input.close();
} catch (Exception e) {
     Log.e(CLIENT_TAG, "Server loop error: ", e);
}