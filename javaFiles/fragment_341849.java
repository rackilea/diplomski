JLabel playLabel = new JLabel(new ImageIcon("./play.png"));

playLabel.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent evt) {
           playLabel.setIcon(new ImageIcon("./play_clicked.png");
           //Some action
      }
}