Timer timer = new Timer(500, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.repaint();
    }
});
timer.setRepeats(false);
timer.start();