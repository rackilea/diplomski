firstActivityButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
         Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
         intent.putExtra("Editext2Data", getIntent().getStringExtra("Edittext2"););
         startActivity(intent);
            }
        });