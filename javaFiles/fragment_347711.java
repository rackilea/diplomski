/** save informations if ConfirmDialog return true */
private void save(){
    ConfirmDialog.show(UI.getCurrent(), "Please Confirm:", "Are you really sure?",
        "I am", "Not quite", new ConfirmDialog.Listener() {
            public void onClose(ConfirmDialog dialog) {
                if (dialog.isConfirmed()) {
                    System.out.println(dialog.isConfirmed());
                } else {
                    System.out.println(dialog.isConfirmed());                       }
            }
        });
}