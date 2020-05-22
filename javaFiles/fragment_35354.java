ActionListener updater = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            String newTime = getTime();
            current.setText(newTime);
        }
    };