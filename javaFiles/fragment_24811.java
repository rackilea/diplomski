public class YourJavaClass
{
  private Session session;

  public static void main()
  {
    ...
  }

  private void connect(String location)
  {
   try
   {
     JSch jsch=new JSch();

     jsch.setKnownHosts(location);

     this.session=jsch.getSession(user, host, SshPortNum);

     String passwd = PasswordVal;
     this.session.setPassword(passwd);
     this.session.connect(30000);  

     session.setPortForwardingL(7051, PcIpNum, VncPortNum);
  }

  private void yourGuiMethod()
  {
   ...
   jButtonDisconnect.addActionListener(new ActionListener()
   {
     public void jButtonDisconnectActionPerformed(java.awt.event.ActionEvent evt)
     {
        this.session.disconnect();
     }
   });  
   ...
  }
}