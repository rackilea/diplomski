@Override
protected void onCreate(Bundle savedInstanceState) {
    // ...

    btAdd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent returnIntent = getIntent();
            returnIntent.putExtra("result", yourEditText.getText().toString());

            setResult(RESULT_OK,returnIntent);
            finish();
        }
    });
}