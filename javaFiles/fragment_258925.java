@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startService();

    //here you have started the service intent
    //if you want to stop the same just call stopService()
}

public void startService(){
    Intent intent = new Intent(this,MyIntentService.class);
    startService(intent);

}

public void stopService(){
  Intent intent=new Intent(this,MyIntentService.class);
    stopService(intent);
}