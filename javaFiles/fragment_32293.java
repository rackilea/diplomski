void updateDialogSize() {
   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   if (dialog.getWidth() < screenSize.getWidth()) { // 1st size width
      dialog.setSize(dialog.getWidth() + 5, dialog.getHeight());
   } else if (dialog.getHeight() < screenSize.getHeight()) { // then size height
     dialog.setSize(dialog.getWidth(), dialog.getHeight() + 5);
   } else {
      timer.stop(); // work done
   }

     dialog.setLocationRelativeTo(myFrame);
}