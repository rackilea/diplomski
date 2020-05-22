public class JccTestListenerImpl implements JccTestListener {

    // jcc specific
    private long pythonObject;

    public JccTestListenerImpl() {}

    @Override
    public void message(String msg) {
        messageImpl(msg);
    }

    // jcc specific
    public void pythonExtension(long pythonObject) {
        this.pythonObject = pythonObject;
    }

    // jcc specific
    public long pythonExtension() {
        return this.pythonObject;
    }

    // jcc specific
    @Override
    public void finalize() throws Throwable {
        pythonDecRef();
    }

    // jcc specific
    public native void pythonDecRef();

    public native void messageImpl(String msg);

}