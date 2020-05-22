CustomInputDialog.showDialog(Test14dialog.this, "Title", fields, new CustomInputDialog.CustomInputDialogListener() {
        @Override
        public void onResult(ArrayList<String> result) {
            this.result = result;
            doThings();
        }
    });