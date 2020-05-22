private class Connect extends AsyncTask<String, Integer, Boolean> {
     protected Boolean doInBackground(String... urls) {
         try {


        client = new Socket("192.168.100.50", 43596);  //Connect to PC server
        printwriter = new PrintWriter(client.getOutputStream(), true);
        printwriter.write(command);  

        printwriter.flush();
        printwriter.close();
        client.close();   //closing the connection

    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
         return false;
     }


 }