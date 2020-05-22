public static void main(String args[]) {
    Person p = new Person("Elliott", 37);
    Field[] fields = p.getClass().getDeclaredFields();
    for (Field f : fields) {
        try {
            f.setAccessible(true);
            String name = f.getName();
            String val = f.get(p).toString();
            System.out.printf("%s = %s%n", name, val);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}