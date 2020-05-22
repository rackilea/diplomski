public static enum E {
    A, B, C, D;
}

public static void main(String[] args) {
    Class c = E.class;
    for(Object b:c.getEnumConstants())
    {
        System.out.println(b);
    }
}