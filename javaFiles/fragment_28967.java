private void formMousePressed(MouseEvent evt) {                                  
    if (evt.isPopupTrigger()) {
        showPopupMenu(evt);
    }
}                                 

private void formMouseReleased(MouseEvent evt) {                                   
    if (evt.isPopupTrigger()) {
        showPopupMenu(evt);
    }
}