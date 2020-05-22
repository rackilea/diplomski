public static <T> void subscribe(T obj, Action<T, String> action) {
    action.invoke(obj, string_);
}

ClassB() {
    ClassA.subscribe(this, new Action<ClassB, String>() {
        public void invoke(ClassB target, String parameter) {
            target.load(parameter);
        }
    });
}