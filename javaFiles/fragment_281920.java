/*
Class for java server to accept incoming stream
and create a new thread to save log file data in server
*/
public class EchoThread extends Thread {
    protected Socket socket;

    public EchoThread(Socket clientSocket) {
        this.socket = clientSocket;
        this.socket.setSoTimeout(10000); //Sets timeout to 10 seconds
    }

    public void run() {
        /*Create a File*/
        int i = 1;
        try {
            File directory = new File("F:/temp/tmplog/" + getDate());
            if(!directory.exists()) {
                directory.mkdir();
            }

            String fileName = "F:/temp/tmplog/" + getDate() + "/" + getDateTime() + ".txt";
            File file = new File(fileName);

            //Double Make Sure it create the file
            while(file.exists()) {
                file = new File(fileName + "." + i);
                i++;
            }
            FileOutputStream fis = new FileOutputStream(file, true);
            PrintStream out = new PrintStream(fis);
            System.setOut(out);


            while (true) {
              try {
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "US-ASCII"));

                String line = null;

                while ((line = br.readLine()) != null) {
                  System.out.println(line);
                }
              } catch (IOException exception) {
                // Just handle next request.
              } finally {
                if (socket != null) {
                  try {
                    socket.close();
                  } catch (IOException ignored) {
                  }
                }
                fis.close();
              }
            }


        } catch (IOException ignored) {
        } catch (SocketException e) { //Exception thrown by timeout
            socket.close(); //We close the socket
            this.stop(); //We stop the thread
        }
    }