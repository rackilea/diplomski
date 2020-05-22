class MyThread implements Runnable
{
    private Socket s;
    private int count;
    private long id;
    InputStream io;
    OutputStream os;
    private PrintWriter pw;

    MyThread(Socket s, int count)
    {
        this.s = s;
        this.count = count;
    }

    public long getId()
    {
        id = Thread.currentThread().getId();
        return id;
    }

    @Override
    public void run()
    {
        try
        {
            io = s.getInputStream();
            os = s.getOutputStream();
        }
        catch (IOException e) {System.err.println(e);}
        try (Scanner sc = new Scanner(io))
        {
            pw = new PrintWriter(os, true);
            pw.println("Connected");
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                System.out.println("Client "+count+": "+line);
                pw.println("Echo: "+line);     
            }
        }
        finally {
            System.out.println("Client " + this.id + " left the session."");
        }   
    }   
}