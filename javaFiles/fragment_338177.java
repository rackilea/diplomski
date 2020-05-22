public class MyPhoneStateListener {
 private Context context;
 public MyPhoneStateListener(Context context) {
   this.context = context;
 }

 public void someMethod() {
    Cursor cur = context.getContentResolver()
     .query(Calls.CONTENT_URI, projection, null, null, Calls.DATE +" desc");
 }
}