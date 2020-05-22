class MyClass implements Consumer<String>{
    @Override
    public void accept(String str) {
        System.out.println(str);
    }
}
Consumer<String> c = new @MyTypeAnnotation("Hello ") MyClass(){/*empty body!*/};