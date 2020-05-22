public void repaint()
{
    display.setGrid(world.getGrid());
    String message = getWorld().getMessage();
    if (message == null)
        message = resources.getString("message.default");
    messageArea.setText(message);
    messageArea.repaint();
    display.repaint(); // for applet
    super.repaint();
}