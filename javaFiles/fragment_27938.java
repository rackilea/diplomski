protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) {
    try {
        super.onTransact(code, data, reply, flags);
    } catch (RuntimeException e) {
        Log.w("MyClass", "Unexpected remote exception", e);
        throw e;
    }
}