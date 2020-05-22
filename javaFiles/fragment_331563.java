Timer timer = new Timer(milliseconds, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                hideMessageDialog();
                Start.this.setVisible(false);
                new czynnośćPL().setVisible(true);
            }
        });
        timer.setRepeats(false);
        timer.start();