panel.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            count++;
            lblNumber.setText("Number of Mouse Clicks = "+ count);
        }
    });