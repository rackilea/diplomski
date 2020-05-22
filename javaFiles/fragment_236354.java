@Override
  protected void onCreate(final Bundle savedInstanceState)
    {
    super.onCreate(savedInstanceState);
    final Intent launchIntent=getPackageManager().getLaunchIntentForPackage("com.android.soundrecorder.SoundRecorder");
    if(launchIntent==null)
      {
      Toast.makeText(this,"can't find the app to launch!",Toast.LENGTH_SHORT).show();
      finish();
      return;
      }
    launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(launchIntent);
    finish();
    }