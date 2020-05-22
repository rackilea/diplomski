JFrame gameFrame = generateFrame();
JPanel panel = (JPanel) gameFrame.getContentPane().getComponent(0);

Component[] comp = panel.getComponents();

for (Component c : comp) {
    JTextField field = (JTextField) c;
    System.out.println("value   :   " + field.getText());
}