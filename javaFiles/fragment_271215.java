private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
   Thread thread = new Thread(new DelayedWriter(jTextField3, jTextField4.getText()));
   thread.start();
}

class DelayedWriter implements Runnable{
    JTextField tf;
    String s;
    public DelayedWriter(JTextField tf, String s){
        this.tf = tf;
        this.s=s;
    }
    public void run(){
        for (int i=0; i< s.length(); i++) 
        {
            tf.setText(s.substring(0,i+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {

            }
        }
    }
}