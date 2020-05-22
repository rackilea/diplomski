ActionListener boardListener = new ActionListener() {
  public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Set All To")) {
        ImageIcon setAll = (ImageIcon) all2.getIcon();
        for (JLabel label : listofLabels) {
           label.setIcon(setAll);
        }
     }
  }
};