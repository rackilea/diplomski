class MyClassLoader extends ClassLoader {
    public MyClassLoader() {
        super(ClassLoader.getSystemClassLoader());
    }

    // Our custom public function for loading from a byte array,
    // this is here just because defineClass is final, so we
    // can't just make it public. Name can be anything you want.
    public Class<?> loadClassFromByteArray(byte[] data)
    throws ClassFormatError {
        return this.defineClass(null, data, 0, data.length);
    }
}