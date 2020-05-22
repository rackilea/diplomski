for(int i = 0; i < ledBtns.length; i++){
  for(int j = 0; j < ledBtns[i].length; j++){
    //init stuff
    final int finalI = i;
    final int finalJ = j;
    ledBtns[i][j].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
      changeImage(finalI,finalJ);
    }
  });
}