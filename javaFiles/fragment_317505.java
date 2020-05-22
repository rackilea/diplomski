static Class<?> clazz = MyIf.class;

public static void main(String[] args) throws Exception {
    method(() -> System.out.println("hello")); // lambda

}

public static void method(MyIf myIf) { 
    System.out.println(clazz.isAssignableFrom(myIf.getClass()));
}

static interface MyIf {
    public void execute();
}