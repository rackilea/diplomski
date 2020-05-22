public interface CLibrary extends Library {
    // define an interface that wraps the callback code
    public interface ExampleCallbackInterface extends Callback {
        void invoke(String val);
    }

        // functions available in library (name must match)
    public void exampleMethod(String  value);
    public void example_triggerCallback(ExampleCallbackInterface callback);
}

// define an implementation of the callback interface
public static class CallbackExample implements Example22CallbackInterface {
    private CLibrary lib;

    public CallbackExample(CLibrary useLib) {
        lib = useLib;
    }

    @Override
    public void invoke(String val) {
        lib.exampleMethod(val);
    }
}

...
final CLibrary clib = (CLibrary)Native.loadLibrary("testlib", CLibrary.class);
...
// instantiate a callback wrapper instance
final CallbackExample callback = new CallbackExample(clib);

// pass the callback wrapper to the C library
clib.example_triggerCallback(callback);