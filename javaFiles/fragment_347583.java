public void testXyz throws Exception() {
    MyClass fake = new MyClass() {
        public int methodB(){
            return 12;
        }
    };

    fake.methodA();
}