private class SendData extends AsyncTask<Void, Void, Void> {

        String ip;
    int port;
    String msg;

    SendData(String ip,int port,String msg)
    {
        this.ip = ip;
        this.port = port;
        this.msg = msg;
    }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog


        }

        @Override
        protected Void doInBackground(Void... arg0) {
 try
{
  socket = new Socket();  
  socket=new Socket(ip,port); 
  PrintWriter writer = new PrintWriter(new BufferedWriter
          (new OutputStreamWriter(socket.getOutputStream())));
        //    BufferedWriter writer=new BufferedWriter(new OutputStreamWriter
       //               (socket.getOutputStream()));
       //       writer.write(msg);
    writer.println(msg);
    writer.flush();
    writer.close();       
    socket.close();
}
catch(UnknownHostException e)
{
    Log.e(TAG, "UnknownHostException");
    e.printStackTrace();
} catch (IOException e) 
{
    Log.e(TAG, "IOException");
    e.printStackTrace();
}
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog

        }

    }