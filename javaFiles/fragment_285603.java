Button button = (Button)findViewById(R.id.button_name);    
button.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
          Log.i(TAG,"CLICKED");
          Intent intent = new Intent(YOUR_CLASS.this, Main2Activity.class);
          startActivity(intent);
      }
});