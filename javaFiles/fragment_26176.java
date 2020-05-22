public class Request {
   private Context context;
   ...
   public Request(Context context) {
      this.context = context;
      try {
         Intent intent = context.getIntent();
         Bundle extras = intent.getExtras();   // <-- I'll betcha' this is returning "null"
         this.arguments = new Arguments(extras);
         ...
      } catch (Exception e) {
         Log.i("output", "no arguments has been found " + e.toString());
      }
      ...