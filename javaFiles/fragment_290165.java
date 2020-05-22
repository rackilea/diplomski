private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {
        try {
            jiframe1.getSearch().dispose();
        } catch (Exception ex) {
            Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }