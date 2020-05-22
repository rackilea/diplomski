JButton run = new JButton("Run");
run.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (Run.isEnabled()) {
                errorLabel.setText("");
                System.out.println("Run action peformed.");

            }
        }