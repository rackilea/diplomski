ActionListener timerTask = new ActionListener() {
    @Override
    public void actionPerformed(final ActionEvent e) {
        panel.repaint();
    }
};

Timer timer = new Timer(50, timerTask);