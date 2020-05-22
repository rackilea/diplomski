final JButton btn = new JButton("Close");

btn.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent evt) {
    Window w = SwingUtilities.getWindowAncestor(btn);

    if (w != null) {
      w.setVisible(false);
    }
  }
});