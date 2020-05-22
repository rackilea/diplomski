cx.setWrapFactory(new WrapFactory() {
  @Override public Object wrap(Context cx, Scriptable scope, Object obj, Class<?> staticType) {
    final Object ret = super.wrap(cx, scope, obj, staticType);
    if (ret instanceof Scriptable) {
      final Scriptable sret = (Scriptable) ret;
      if (sret.getPrototype() == null) sret.setPrototype(new NativeObject());
    }
    return ret;
  }
});