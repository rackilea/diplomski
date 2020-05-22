Timer timer = new Timer(1000 / TARGET_FPS, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        //...
    }
});
timer.start();