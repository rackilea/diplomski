private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
  Thread t1 = new Thread(new Runnable() { public void run(){
    apppane_threadsafe( ... );
    // do your ftp stuff
    apppane_threadsafe( ... );
  }});
  t1.start();
}