Intent myIntent = new Intent(ListenSMSservice.this,LockScreenForm.class);
myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
Bundle myKillerBundle = new Bundle();
myKillerBundle.putInt("kill",1);
myIntent.putExtras(myKillerBundle);
getApplication().startActivity(myIntent);