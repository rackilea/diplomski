public void correctAtLeastTenCharsMegsértések(Object o)
        throws IllegalArgumentException, IllegalAccessException {

    Class<?> objClass = o.getClass();
    Field[] fields = objClass.getDeclaredFields();

    for (Field field : fields) {

        field.setAccessible(true);
        Object value = field.get(o);
        if (value instanceof String) {
            StringBuilder sb = new StringBuilder((String)value);
            while (sb.length() > 0 && sb.length() < 10) {
                sb.append(value);
            }
            field.set(o, sb.toString());
            System.out.println(sb.toString());
        }

    }
}