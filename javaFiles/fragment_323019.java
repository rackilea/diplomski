private void createGameLevelMenuItems(JMenu menu){

  for (int i = 0; i<10; i++) {
    final int j = i;   // <--- this line do the thing
    JMenuItem item = new JMenuItem(new AbstractAction("Level-" + j) {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.loadGame(j);
            board.refresh();
            pack();
        }
    });
    menu.add(item);
  }
}