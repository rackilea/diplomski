public class MyPanel extends JPanel implements ActionListener
{
    private SocketMessageSender messageSender;
    private Message jMessage = new Message();// This is just a temp class, replace this with your class

    public MyPanel()
    {
        messageSender = new SocketMessageSender("some host", 8080);
        try
        {
            messageSender.initConnection();
        }
        catch(IOException e)
        {
             Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        try {
            // TODO add your handling code here:
            messageSender.sendMessage(jMessage.getText()); 
            jMessage.setText("");
        } catch (IOException ex) {
            Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}