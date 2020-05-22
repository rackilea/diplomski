Intent intent = new Intent(this, MyService.class);
intent.putExtra("prm1", val1);
intent.putExtra("prm2, val2);
startService(intent);

 Or 

Intent intent = new Intent(this, MyService.class);
Bundle bundle = intent.getExtras();
bundle.putString("prm1", val1);
bundle.putString("prm2", val2);
startService(intent);

And in the service
Intent intent = getIntent();
if((null != intent) && (null != intent.getExtras()) {
      Bundle bundle = intent.getExtras();
      String prm1Value = bundle.getString(prm1);
      String prm2Value = bundle.getString(prm2);
}