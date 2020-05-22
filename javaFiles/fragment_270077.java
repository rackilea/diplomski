private MethodHandle handle;
public Object callReturn(Object... args) throws Exception {
    try {
        if(handle == null) {
            final MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle h = lookup.unreflect(this.getMethod());
            handle = h.asType(h.type().generic())
                      .asSpreader(Object[].class, h.type().parameterCount());
        }
        return handle.invokeExact(args);
    } catch (Throwable ex) {
        throw new Exception(ex);
    }
}