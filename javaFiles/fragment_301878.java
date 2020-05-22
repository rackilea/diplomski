public BoardPanel() {

    BoardMouseListener bml = new BoardMouseListener();
    addMouseListener(bml);
    addMouseMotionListener(bml);
}