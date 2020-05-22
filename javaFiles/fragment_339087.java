public void share(View view){

    Intent intent = new Intent(Intent.ACTION_SEND);
    intent.setType("text/plain");
    EditText msg = (EditText)findViewById(R.id.edit);
    String finalMsg = String.valueOf(msg.getText().toString().trim());
    intent.putExtra(Intent.EXTRA_TEXT, finalMsg);
    Intent modIntent = Intent.createChooser(intent, "Send With..");
    startActivity(modIntent);
}