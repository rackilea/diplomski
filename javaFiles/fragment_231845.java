mainwindow.addComponentListener(new java.awt.event.ComponentAdapter() {
        @Override
        public void componentMoved(java.awt.event.ComponentEvent evt) {
            GlowneComponentMoved(evt);
        }
    });

//and the listener....
private void GlowneComponentMoved(ComponentEvent evt) 
{
      this.setLocation( (Okno_Glowne.getX()+ Okno_Glowne.getWidth()+10), Okno_Glowne.getY());   
}