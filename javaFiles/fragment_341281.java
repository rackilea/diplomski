public PlayMusic() {
initComponents();
initAudioStream();
}

AudioStream ikon;

private void initAudioStream(){
            InputStream in = new FileInputStream(new File("C:\\Users\\A\\Downloads\\Music\\I.wav"));
            ikon = new AudioStream(in);         
}

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         

    try{
        if(evt.getSource()== jButton1){

        AudioPlayer.player.start(ikon);  }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);}

}

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         try{   
        if(evt.getSource()== jButton3)
        {
        AudioPlayer.player.stop(ikon);
        }
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);}
}