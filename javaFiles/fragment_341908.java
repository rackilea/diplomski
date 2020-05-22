public void mouseClicked(MouseEvent e) {
    if (e.getButton() == 1) {
        editMode = !editMode;

        // **** added ****
        if (editMode) {
            requestFocusInWindow();
        }            
    }
}