public void send(View view) {
    String editTextAContents = findViewById(R.id.a).getText().toString();
    String editTextBContents = findViewById(R.id.b).getText().toString();

    Intent intent = new Intent(this, DisplayActivity.class);

    if (editTextAContents.equalsIgnoreCase(editTextBContents)) {
        intent.putExtra("message", "Case Ignored \n VALUES ARE THE SAME CONGRATS");
        intent.putExtra("error", false);
    } else {
        intent.putExtra("ict402.germio.intent", "Case Igored \n VALUES ARE NOT THE SAME SORRY!");
        intent.putExtra("error", true);
    }

    startActivity(intent);
}