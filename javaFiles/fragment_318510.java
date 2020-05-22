public static class MyStruct extends Struct {
  public MyStruct(Runtime runtime) {
    super(runtime);
  }

  public final Struct.Signed32 classes = new Struct.Signed32();
  // For char* the support is built-in
  public final Struct.String names = new Struct.UTF8StringRef();
  // For char** you could wrap a pointer and override getStringMemory
  public final UTF8StringRef[] names2 = UTF8StringRefArray(new Struct.Pointer(), 2);

  protected UTF8StringRef[] UTF8StringRefArray(Pointer pointer, int stringLength) {
    UTF8StringRef[] array = new UTF8StringRef[stringLength];
    for (int i = 0; i < array.length; i++) {
      int index = i;
      array[i] = new UTF8StringRef() {
        @Override
        protected jnr.ffi.Pointer getStringMemory() {
          return pointer.get().getPointer(getRuntime().addressSize() * index);
        }
      };
    }
    return array;
  }
}