public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        createAndShowGUI();
     }
  });
}

private static void createAndShowGUI() {
  // create and display your GUI from in here
  MainGui mainGui = new MainGui();

  JFrame mainFrame = new JFrame("Main GUI");
  mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  mainFrame.add(mainGui);
  mainFrame.pack();
  mainFrame.setLocationRelativeTo(null);

  mainFrame.setVisible(true);
}