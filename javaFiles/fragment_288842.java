String android_id; 

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.tst);
    android_id = Secure.getString(getContentResolver(),Secure.ANDROID_ID);
    Log.d("UUID", android_id);
}