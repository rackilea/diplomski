ClassABC abc = new ClassABC();
for (Field field : abc.getClass().getDeclaredFields()) {
    field.setAccessible(true);
    String name = field.getName();
    Object value = field.get(abc);
    System.out.printf("Field name: %s, Field value: %s%n", name, value);
}