public class View extends JFrame {
  public View(final ActionListener listener) {
   JButton button = new JButton("click me");
   button.addActionListener(listener);
   button.setActionCommand("do_stuff");

   getContentPane().add(button);

   pack();
   setVisible(true);
  }
 }

 public class Control implements ActionListener {

  public Control() {
   new View(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
   if (e.getActionCommand().equals("do_stuff")) {
    // respond to button click
   }
  }
 }