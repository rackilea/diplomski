public static void changeJLabel(JPanel panelName, JLabel JLabel, String newText)
{
    JLabel.setText(newText);
    panelName.validate();
    panelName.repaint();
}