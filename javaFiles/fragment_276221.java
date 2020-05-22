SwingUtilities.invokeLater(new Runnable() {
       public void run() {
         javax.swing.UIManager.setLookAndFeel("newlook&feel");
         SwingUtilities.updateComponentTreeUI(OuterClassName.this);
         pack();
        }
      });