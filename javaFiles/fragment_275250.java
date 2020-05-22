public static void main(String[] args) throws Exception {
    Class<?> clazz = Student.class;
    Map<Object, Object> map = new HashMap<>();
    Field[] fields = clazz.getDeclaredFields();
    for (Field field : fields) {
        Identifier annotation = field.getAnnotation(Identifier.class);
        if (annotation != null) {
            map.put(field.getType(), clazz);
        }
    }
    System.out.println(map);
}