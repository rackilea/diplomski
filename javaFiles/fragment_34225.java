DialogBox editCustDialog;

public void onClick(ClickEvent event) {
    if (editCustDialog == null) {
        buildEditCustDialog();
    }
    editCustDialog.show(); // or, editCustDialog.center();
}

private void buildEditCustDialog() {
    editCustDialog = new DialogBox();
    // etc.
}