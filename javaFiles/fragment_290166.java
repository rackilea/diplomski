private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {
    try {
        Search s=jiframe1.getSearch();
        if(s!=null)
        s.dispose();
    } catch (Exception ex) {
        Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
    }
}