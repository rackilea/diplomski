public class MyActivity extends Activity {

   @Override
   public void onCreate() {

      // If you want to call your static function, you do not
      // require an instance of a MyFunctionClass object.
      String myStaticString = MyFunctionClass.myStaticFunction();

      // If you want to call your instance function, then you need
      // to create a MyFunctionClass first.
      MyFunctionClass variableName = new MyFunctionClass();
      String myInstanceString = variableName.myFunction();
   }
}