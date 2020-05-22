public class Client
{
    public static void main(String[] args) throws IOException, Throwable
   {

        Socket s;
        BufferedReader in;
        PrintWriter out;
        Scanner sc = new Scanner(System.in);
        s = new Socket(InetAddress.getLocalHost(), 9000);
        System.out.println("Connection pending");
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(s.getOutputStream());

        ReceiveMessageThread thread = new ReceiveMessageThread(in);
        String msg = in.readLine();
        System.out.println(msg);

        thread.start();
        while (msg != "")
        {
            msg = sc.nextLine();
            out.println(msg + "\n");
            out.flush();

        }
        s.close();
        sc.close();
    }

    public static class ReceiveMessageThread extends Thread
    {
        private BufferedReader in;

        public ReceiveMessageThread(BufferedReader in)
        {
            this.in = in;
        }

        public void run()
        {
            while (true)
            {
                try
                {
                    String message = readMessage(in);
                    if (message != null && !message.equals(""))
                    System.out.println(message);
                } catch (IOException ie)
                {
                    ie.printStackTrace();
                }
            }
        }

        public String readMessage(BufferedReader in) throws IOException
        {
            String msgreceived = "";
            String readValue = "";
            while (in.ready())
            {
                readValue = in.readLine();
                if (readValue != null)
                    msgreceived += readValue;
            }
            return msgreceived;
        }
    }


}