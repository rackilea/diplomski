bVerify.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {
        /** Called when the user clicks the Next button */
        Log.d("EditText", nameE2);
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE, nameE2);
        startResultActivity(null);
    }
});