View.OnClickListener welcomeListener = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
  Intent intent = newIntent(YourCurrentActivity.this,MainActivity.class);
        startActivity(intent);
    }
};
btn.setOnClickListener(welcomeListener);
}