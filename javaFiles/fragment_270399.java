Platform.runLater(new Runnable() {
        @Override
        public void run() {
            Notification.this.topicLabel.setText(message.getHeader());
            Notification.this.messageLabel.setText(message.getText());
        }
    });