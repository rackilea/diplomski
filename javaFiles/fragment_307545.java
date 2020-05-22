for (int i = 1; i < lines.size(); i+=2)
{
    String question = lines.get(i - 1);
    String answer   = lines.get(i);
    JOptionPane.showInputDialog("Question: " + question + " Answer:" + answer);
}