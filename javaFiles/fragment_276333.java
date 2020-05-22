void myMethod(int val) {
    MyClass cls = new MyClass() {
        @override
        void doAction() {
            callMethod(val);  // use the val argument in the anonymous class - closure!
        }
    };
    useClass(cls);
}