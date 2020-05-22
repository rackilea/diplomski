Updatable<JLabel> updatableJLabel = new Updatable<JLabel>() {
        private JLabel jLabel;

        public void setComponent(JLabel jButton) {
            this.jLabel = jButton;
        }

        public void update() {
            jLabel.setText("someText");
        }   
    };

    updatableJLabel.setComponent(new JLabel());
    updatableJLabel.update();