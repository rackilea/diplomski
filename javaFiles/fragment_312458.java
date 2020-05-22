final int[] path = { MOVE_RIGHT, MOVE_DOWN, MOVE_UP, MOVE_UP, MOVE_LEFT, MOVE_DOWN };
Timer t = new Timer(1000 * 1, new ActionListener() {
    private int step = 0;
    public void actionPerformed(ActionEvent e) {
        move(path[step]);
        step = (step + 1) % path.length;
    }
});