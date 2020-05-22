private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){
    Thread thread = new Thread(){
        public void run(){
            GUI2 newGui = new GUI2();
            newGui.setVisible(true);
        }
    };  
    thread.start();
}