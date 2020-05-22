//Server
public void writeLine(String linea)
{
    try
    {
        if (this.oos != null)
        {
            oos.writeObject(linea);
            servertalkstogui.getTextField().setText("");//clearing JTextField
            servertalkstogui.getAreachat().append("\n I say: " + linea);
        }
    }
    catch (IOException e)
    {
        e.getLocalizedMessage();
    }
}


//Client
public void writeLine(String linea)
{
    try
    {
        if (this.oos != null)
        {
            // to send it to the server
            oos.writeObject(linea);
            clienttalkstogui.getTextField().setText("");//clear the text when it have been read
            // to have it displayed on the client window too
            clienttalkstogui.getAreachat().append(linea);
        }
    }
    catch (IOException e)
    {
        // this.closeClient();
        e.getLocalizedMessage();
    }
}