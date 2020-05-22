private static void createAndShowGui() {
      LoginDialog loginDialog = new LoginDialog();
      loginDialog.setVisible(true);

      // however you verify that the user is authentic
      if (loginDialog.verify()) {
         MainGui mainGui = new MainGui();
         mainGui.setVisible(true);
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }