private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    new Thread(new Runnable() {
        @Override
        public void run() {
            // This gets run in a background thread
            String text = jTextArea1.getText();
            jTextArea2.append(client.getCurrentName() + " : " + text + "\n");
            MainClient.setText(client.getCurrentName() + " : " + text + "\n");
            MainClient.active();
        }
    }).start();
}