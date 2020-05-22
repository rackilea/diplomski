final JButton button = new JButton('click to continue');
button.setAction(new AbstractAction() {
  public void actionPerformed(ActionEvent ae) {
    synchronized (button) {
      button.notify();
    }
  }
});
JFrame jf = new JFrame("Window");
jf.getContentPane().add(button, BorderLayout.CENTER);
jf.setDefaultCloseOperation(...);
jf.pack();
jf.setVisible();
synchronized(button) {
  try {
    button.wait();
  } catch (InterruptedException ex) {
    System.out.println("Interrupted");
  }
}
System.out.println("After button clicked");