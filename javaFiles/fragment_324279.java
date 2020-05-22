public class demo extends JFrame implements ActionListener
{
    class demo()
    {

          CustomJFrame frame = new CustomJFrame();
          JPanel pane = new JPanel(new GridBagLayout());

          GridBagConstraints c = new GridBagConstraints();
          JTextField dummyText = new JTextField("I'm some text");
          JLabel dummyLabel = new JLabel("I'm a label);

          JButton dummyButton = new JButton("I'm a button");

          c.fill = GridBagConstraints.BOTH;
          c.gridx = 0;
          c.gridy = 0;
          pane.add(dummyText, c);

          c.fill = GridBagConstraints.BOTH;
          c.gridx = 1; 
          c.gridy = 0;
          pane.add(dummyLabel, c);

          c.fill = GridBagConstraints.BOTH;
          c.gridx = 0;
          c.gridy = 2; 
          pane.add(dummyButton, c);

          pane.setOpaque(false);
          frame.setGlassPane(pane);
          pane.setVisible(true);

    }

}