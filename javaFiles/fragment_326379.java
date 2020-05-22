Consumer<String> c = new @MyTypeAnnotation("Hello ") Consumer<String>() {
    @Override
    public void accept(String str) {
        System.out.println(str);
    }
};