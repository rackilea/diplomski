Updatable<JButton> updatableButton = new Updatable<JButton>() {
        private JButton jButton;

        public void setComponent(JButton jButton) {
            this.jButton = jButton;
        }

        public void update() {
            jButton.setText("someText");
        }   
    };

    updatableButton.setComponent(new JButton());
    updatableButton.update();