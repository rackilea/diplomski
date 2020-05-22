@SuppressWarnings("rawtypes")
Class clazz = Class.forName("com.mycompany.MyEnum");
if (clazz.isEnum()) {
    @SuppressWarnings("unchecked")
    Enum<?> o = Enum.valueOf(clazz, "PEER");
    System.out.println(o.name());
    System.out.println(o.ordinal());
}