public interface MyLib extends Library {
    class MyStruct extends Structure {
        public Pointer p;
        protected List getFieldOrder() {
            return Arrays.asList("p");
        }
    }
    void print(MyStruct s);
}

MyLib lib = Native.loadLibrary("mylib", MyLib.class);
MyStruct s = new MyStruct();
s.p = new Memory(length * 4);
lib.print(s);