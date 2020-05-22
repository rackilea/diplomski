public synchronized void actionPerformed(ActionEvent evt)
{
    textArea.setText("");
    String text = tfIn.getText();
    tfIn.setText("");
    inWriter.println(text); 
}