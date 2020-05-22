final Button button = (Button) findViewById(R.id.button1);
  button.setOnClickListener(new OnClickListener() {

  @Override
  public void onClick(View v) {
    Intent intent = new Intent(Pageaccueil.this, Devise.class);
    startActivity(intent);
    }
});
   }