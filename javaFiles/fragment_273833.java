public static void main(String[] args) {
    ServiceLoader<MyInterface> loader = ServiceLoader.load(MyInterface.class);
    for (MyInterface api : loader) {
        api. ...
    }
    // Or take the first implementation:
    MyInterface api = loader.iterator().next();
}