public void actionPerformed(ActionEvent e) {
  Object o = e.getSource();
  if (o instanceof JComponent) { 
    JComponent component = (JComponent)o; 
    Window win = SwingUtilities.getWindowAncestor(component);
    win.dispose();
  }
}