@Override
    public void onClick(View v) {
        if (etTitle.length() != 0 || etDes.length() != 0){
            String title = etTitle.getText().toString();
            String description = etDes.getText().toString();
            Activity2.launch(this,title,description);
        } else {
            Toast.makeText(DataInput.this, "Please Add Data !", Toast.LENGTH_SHORT).show();
        }
    }