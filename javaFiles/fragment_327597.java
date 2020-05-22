button.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent arg0) {
   MyCustomProgressBarDialog progressBarObj = new    MyCustomProgressBarDialog(progressBar);
   progressBarObj.createProgressUI();

   MyActionPerformer actionObj = new MyActionPerformer(progressBar);
   actionObj.execute();

   progressBarObj.setVisible(false);
  }
});