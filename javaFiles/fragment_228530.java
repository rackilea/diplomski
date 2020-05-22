@Override
public void onCreate() {
    super.onCreate();

    ContentResolver contentResolver = this.getContentResolver();
    contentResolver.registerContentObserver(Uri.parse("content://sms/out"),true, new SmsObserver(new Handler()));
}