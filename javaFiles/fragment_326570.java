Timer timer = new Timer(10000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            HoorayWithTimer.this.setVisible(false);
            HoorayWithTimer.this.dispose();
        }
    });
    timer.start();