private class MyListener implements ActionListener {
  public void actionPerformed(ActionEvent e) {
     System.out.println("Button pressed: " + e.getActionCommand());
     ((JButton)e.getSource()).setEnabled(false);
  }
}