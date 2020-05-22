JPanel panel = new JPanel(new FlowLayout());
    JButton button = new JButton("Add");
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton newButton = new JButton("New Added Bnt");
            panel.add(newButton);
        }
    });