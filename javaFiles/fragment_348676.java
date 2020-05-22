/**
 * Saves checked state of the packages.
 */
private void saveChecked() { 
    ICConfigurationDescription desc = getResDesc().getConfiguration();
    ICStorageElement strgElem = null;
    try {
        strgElem = desc.getStorage(PACKAGES, true);
    } catch (CoreException e) {
        e.printStackTrace();
    }

    TableItem[] items = pkgCfgViewer.getTable().getItems();
    for(TableItem item : items) {
        if(item != null) {
            String chkd;
            if(item.getChecked()) {
                chkd = "true";
            } else {
                chkd = "false";
            }
            try {  
                String pkgName = item.getText();
                strgElem.setAttribute(pkgName, chkd);
            } catch (Exception e) {
                /*
                 * INVALID_CHARACTER_ERR: An invalid or
                 * illegal XML character is specified. 
                 */
            }
        }
    }
}

/**
 * Initializes the check state of the packages from the storage.
 */
private void initializePackageStates() {
    ICConfigurationDescription desc = getResDesc().getConfiguration();
    ICStorageElement strgElem = null;
    try {
        strgElem = desc.getStorage(PACKAGES, true);
    } catch (CoreException e) {
        e.printStackTrace();
    }
    TableItem[] items = pkgCfgViewer.getTable().getItems();
    for(TableItem item : items) {
        String value = strgElem.getAttribute(item.getText());
        if(value!=null) {
            if(value.equals("true")) {
                item.setChecked(true);
            }
        }
    }
}