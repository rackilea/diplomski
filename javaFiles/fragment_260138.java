SwingUtilities.invokeLater(() -> {
   MenuBar menuBar = new MenuBar();

   JFrame frame = new JFrame("Menu");       
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   frame.setJMenuBar(menuBar.menuBar);
   frame.setSize(900, 800);
   frame.setVisible(true);
});