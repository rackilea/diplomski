public class MyClass {
  private static MyCallbackInterface myCallback;

  private MyClass() {
    myCallback = new CallbackInterface() {
      @Override
      public int callback(/* parameters */) {
        // Do stuff with data here
        return 0;
      }
    }

    nativeLib.SetCallback(myCallback);
  }