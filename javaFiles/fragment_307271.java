protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    onNewCheckPoint();
}

private void onNewCheckPoint(){
   Intent intent = getIntent();
   Bundle extras = intent.getExtras();    
  //in this moment, you can process data, like you want.
}