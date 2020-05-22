if(getDialogType() == SAVE_DIALOG) {
    if(f.exists()) {
        // your overwrite checking
    } else {
        super.approveSelection();
        return;
    }
}