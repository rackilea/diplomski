JButton button = (JButton) event.getSource();
String command = button.getText();

if (command.equals("About Failsafe"))
{
  AboutFrame abt = new AboutFrame();
  abt.setVisible(true);
}