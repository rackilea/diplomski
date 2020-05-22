Class<?> cls = Class.forName("Greeter");
try {
    Object o = cls.getConstructor(null).newInstance(null);
    System.out.println(((Greeter) o).getGreeting());
} catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}