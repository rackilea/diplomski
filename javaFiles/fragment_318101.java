public class ClientThread implements Runnable {
    public void run() {
            try {
                Socket socket = new Socket(serverIpAddress, serverPort);
                connected = true;
                Log.d("ClientActivity", "Client Connected");
                    try {
                        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                        out.println(launchercontrolcode);
                        Log.d("ClientActivity", "Cliend Sent Code");
                        out.flush();
                        out.close();
                    } catch (Exception e) {}
                    socket.close();
                    Log.d("ClientActivity", "Post-socket close");
                } catch (Exception e) {      

        }finally{
          connected = false;
      }

    }
}
}