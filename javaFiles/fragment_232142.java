import java.net.*;
    import java.io.*;
    import java.util.Arrays;

    // A client for our multithreaded EchoServer.
    public class client
    {
        public static void main(String[] args)
        {
            Socket socket = null;
            int PORT = 5000;

           // Create the socket connection to the EchoServer.
            try
            {
                socket = new Socket("localhost", PORT);
            }        
            catch(UnknownHostException uhe)
            {
                // Host unreachable
                System.out.println("Unknown Host");
                socket = null;
            }
            catch(IOException ioe)
            {
                // Cannot connect to port on given host
                System.out.println("Cant connect to server at 5000. Make sure it is running.");
                socket = null;
            }

            if(socket == null)
                System.exit(-1);
            try
            {
                File file = new File("ext.txt");
                byte[] bytes = new byte[8192];
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream out = socket.getOutputStream();

                int count,file_size;

                while ((count = bis.read(bytes)) > 0) {
                    System.out.println(count);
                    out.write(bytes, 0, count);
                }
                out.flush();
                out.close();
                fis.close();
                bis.close();
            }  
            catch(IOException ioe)
            {
                System.out.println("Exception during communication. Server probably closed connection.");
            }
            finally
            {
                try
                {
                    // Close the socket before quitting
                    socket.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }                
            }        
        }
    }