Field[] fields = obj1.getClass().getDeclaredFields();

for (Field field : fields) {
    field.setAccessible(true);
    String name = field.getName();
    Object value = field.get(obj1);
    if (value != null) {
        System.out.println(name + " = " + value);
    }
}