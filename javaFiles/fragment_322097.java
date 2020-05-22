public class ClientHandler implements Runnable {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientHandler(Socket socket)
    {
        this.socket = socket;
    }

    @Override
    public void run() {
        try
        {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String message = reader.readLine();
            while (message != null)
            {
                writer.write(message + System.lineSeparator());
                writer.flush();
                message = reader.readLine();
            }
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}