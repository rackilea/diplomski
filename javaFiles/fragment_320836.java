Timer timer1 = new Timer(1, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        game.repaint();
    }
});
timer1.start();

Timer timer2 = new Timer(10, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        game.move();
    }
});
timer2.start();