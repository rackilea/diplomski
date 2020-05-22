class Worker extends SwingWorker<String, Object> {

    @Override
    protected String doInBackground() throws Exception {
       //here you send the mail
       return "DONE";
    }

    @Override
    protected void done() {
        super.done();
        //this is executed in the EDT
        JOptionPane.showMessageDialog(null, "Message sent", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}