public static Object[] objects;

public static void main(String[] args) {
    new Class2();

    objects = { object1, object2 };
    for (Object o : objects) {
        System.out.println(o);
    }
}