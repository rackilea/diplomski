// Your Game class in the core package
public class MyGame extends Game {

    // Define an interface for your various callbacks to the android launcher
    public interface MyGameCallback {
        public void onStartActivityA();
        public void onStartActivityB();
        public void onStartSomeActivity(int someParameter, String someOtherParameter);
    }

    // Local variable to hold the callback implementation
    private MyGameCallback myGameCallback;

    // ** Additional **
    // Setter for the callback
    public void setMyGameCallback(MyGameCallback callback) {
        myGameCallback = callback;
    }

    @Override
    public void create () {
        ...
    }

    ...

    private void someMethod() {
        ...
        // check the calling class has actually implemented MyGameCallback
        if (myGameCallback != null) {

            // initiate which ever callback method you need.
            if (someCondition) {
                myGameCallback.onStartActivityA();
            } else if (someOtherCondition) {
                myGameCallback.onStartActivityB();
            } else {
                myGameCallback.onStartSomeActivity(someInteger, someString);
            }

        } else {
            Log.e("MyGame", "To use this class you must implement MyGameCallback!")
        }
    }
}