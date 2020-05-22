Timer t = new Timer(1000 * 1, new ActionListener() {
    private boolean moveRight = true;
    public void actionPerformed(ActionEvent e) {
        if (moveRight)
            move(MOVE_RIGHT);
        else
            move(MOVE_DOWN);
        moveRight = ! moveRight;
    }
});