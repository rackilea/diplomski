private void populateDisplay(int id) {

        Cursor csr = dbAdapter.getRecordById(id);
        if (csr.moveToFirst()) {
            editText.setText(csr.getString(csr.getColumnIndex(DBAdapter.KEY_NAME)));
            editText2.setText(csr.getString(csr.getColumnIndex(DBAdapter.KEY_AMOUNT)));
            editText3.setText(csr.getString(csr.getColumnIndex(DBAdapter.KEY_DUEDATE)));
        }
        csr.close();
    }