public void startServer()
{
    try
    {
        server = new ServerSocket(port);
        while (true)
        {

            s = server.accept();

            s.getInputStream();

            conversationBox.appendText("Client connected from " + s.getLocalAddress().getHostName() + "\n");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            char buffer[] = new char[1024];
            conversationBox.appendText("Reading....");
            while(br.read(buffer) > 0)
            {
                conversationBox.appendText("Client Say : " + new String(buffer));
                bw.write(buffer);
                bw.flush();
            }
            conversationBox.appendText("Reading Done....");
        }
    }
    catch (Exception e)
    {
        conversationBox.appendText("An error occurred.\n");
        e.printStackTrace();
        isServer = false;
        reEnableAll();
    }
}