class SomeUI
{
   SocketMessageSender messageSender;
   // ensure that its initialized ...



 private void bSendMessageActionPerformed(java.awt.event.ActionEvent evt) {
    messageSender.sendMessage(jMessage.getText());
    jMessage.setText("");
 }
}