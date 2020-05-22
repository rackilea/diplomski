btnFightCrime.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (JOptionPane.showConfirmDialog(null, "This action will cost you 5 energy points, and you'll gain 5 action points.", "Proceed?",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Crimes.randomCrime();
            fightCrime(iActionBar);
            Random r = new Random();
            int delay = 0;
            //delay is * 1000 because the format for timers is milliseconds
            timer = new Timer((delay * 0), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    btnFightCrime.setVisible(true);
                    btnIgnore.setVisible(true);
                    lblVillainCrime.setVisible(false);
                    lblHeroCrime.setVisible(true);

                    frame.validate();
                    timer.stop();
                }
            });
            timer.start();
            btnFightCrime.setVisible(false);
            btnIgnore.setVisible(false);
            lblHeroCrime.setVisible(false);
            frame.validate();

        }
    }
};