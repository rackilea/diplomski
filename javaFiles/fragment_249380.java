public void push(String message)
{
    log.setText(log.getText() + "\n" + message);
    log.selectPositionCaret(log.getLength());
    log.deselect();
}