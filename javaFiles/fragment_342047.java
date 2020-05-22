private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       thisXcurrent = this.getLocation().x;
       thisYcurrent = this.getLocation().y;                   
       rv = this.getSize();
       this.setSize(screenRect.width, screenRect.height);
       this.setLocation(0, 0);


}                                        

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         

      this.setSize(rv);
      this.setLocation( thisXcurrent,  thisYcurrent);


}