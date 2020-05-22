public class SomeActivity implements Bridge.Callbacks {

   [...]

   @Override
   protected void onCreate () {
       super.onCreate();
       bridge.onCreate(this);
   }

   [...]

   @Override
   public void onSomeResultComputed (Object result) {
       // Handle the result here
   }

   @Override
   public void onSomeOtherResultComputed (Object result) {
       // Handle the result here
   }
}