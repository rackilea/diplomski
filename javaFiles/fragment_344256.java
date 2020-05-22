@Override
        public void actionPerformed(ActionEvent e) {
            // the source here refers to the object that provoked this method to occur
            JButton sourceBtn = (JButton) e.getSource();
            sourceBtn.setBackground(Color.RED);
        }