public static void printGoodInts(Object obj) throws IllegalArgumentException, IllegalAccessException {
    Field[] fields = obj.getClass().getDeclaredFields();
    for (Field field : fields) {
        if (field.isAnnotationPresent(GoodInt.class)) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(obj));
        }
    }
}