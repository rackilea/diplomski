mainActivityButton.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
        intent.putExtra("Editext1", editText1.getText().toString());
        intent.putExtra("Editext2", editText2.getText().toString());
        startActivity(intent);
        }
    });