JButton show = new JButton("show Form2");
    show.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            PMotion pMotion = new PMotion();
            pMotion.setVisibile(true); // Show pMotion form
            Form1.this.setVisible(false); // Hide current form where Form1 is your current JFrame class
        }

    });