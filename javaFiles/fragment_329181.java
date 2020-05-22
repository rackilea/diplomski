bVerify.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        final String nameE2 = txtDescription.getText().toString();
        /** Called when the user clicks the Next button */
        Log.d("EditText", nameE2);
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, nameE2);
        startResultActivity(intent);
    }
});