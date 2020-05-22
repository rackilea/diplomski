@Override
protected Void doInBackground(Void... voids) {

    try (Socket socket = new Socket(IP, port)) {

        Boolean connectionCancelled = false;

        while (connectionCancelled == false) {

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String message = br.readLine();
            Log.d("StreamingApp", "Server says: " + message);

            publishProgress(message); //!!!! This is it. At this line it 
                                        //crashes, no matter how I put it. 
                                        //Doing it directly here or in an 
                                        //extra method like now.
        }

    } catch (
            UnknownHostException e)

    {
        e.printStackTrace();
    } catch (
            IOException e)

    {
        e.printStackTrace();
    }
    return null;
}