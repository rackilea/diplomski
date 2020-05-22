public interface TestInt extends StdCallLibrary {
    TestInt INSTANCE = (TestInt)Native.loadLibrary("TestInt", TestInt.class);

    class Test extends Structure {
        public String vResult;
        public Test() { }
        public Test(Pointer p) { 
            super(p);
            read();
        }
        protected List getFieldOrder() { return Arrays.asList(new String[] { "vResult" }); }
    }

    String MyReturn(Test test);
}