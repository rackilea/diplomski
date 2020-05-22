SwingUtilities.invokeLater(() -> {
   JFrame frame = new JFrame("Menu");
   frame.setVisible(true);
   frame.setSize(900, 800);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   MenuBar menuBar = new MenuBar();
   frame.setJMenuBar(menuBar.menuBar);
});