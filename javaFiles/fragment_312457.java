Timer t = new Timer(1000 * 1, new ActionListener() {
    private int step = 0;
    public void actionPerformed(ActionEvent e) {
        switch (step) {
            case 0:
                move(MOVE_RIGHT);
                break;
            case 1:
                move(MOVE_DOWN);
                break;
            case 2:
                move(MOVE_UP);
                break;
        }
        step = (step + 1) % 3;
    }
});