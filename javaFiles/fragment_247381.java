private void startThread() {
    new Thread() {
        public void run() {
             MySocket sock1 = new SMTPSocket(s1.getText(),fromField.getText(),subjectField.getText());
        }
    }.start();

}