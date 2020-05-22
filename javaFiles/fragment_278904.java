public static void main(String ... args) {
    Dog d= new Dog("dog1");
    setNameStatic(d, "dog2");
    System.out.println(d); // Still prints dog1 !!!
}

static void setNameStatic(Dog d2, String name) {
    d2= new Dog(name);
}