EventQueue.invokeLater(new Runnable() {
    public void run() {
        ...

        // MOVE it HERE
        class color implements ActionListener {
            public Color c;

            public color(Color bc) {
                c = bc;
            }

            public void actionPerformed(ActionEvent event) {
                panel.setBackground(c);
            }
        }

        // Now use it HERE
        color b = new color(Color.BLACK);
        black.addActionListener(b);
        ...
    }

});