BufferedWriter bw = null;
BufferedReader br = null;
public void startClient()
{
    try
    {
        Socket c = new Socket(host, port);

        bw = new BufferedWriter(new OutputStreamWriter(c.getOutputStream()));
        br = new BufferedReader(new InputStreamReader(c.getInputStream()));

        char buffer[] = new char[1024];
        while (br.read(buffer) > 0)
        {
            Chat.conversationBox.appendText("You Said: " + new String(buffer));
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
}