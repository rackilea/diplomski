button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Log.d("test", "adding");
        db.open();
        long id = db.insertRecord(editText.getText().toString(), editText2.getText().toString(), editText3.getText().toString());
        db.close();
        Toast.makeText(Editbills.this," Added", Toast.LENGTH_LONG).show();
        Intent q = new Intent(getApplicationContext(),bills.class);
        startActivity(q);

    }
});