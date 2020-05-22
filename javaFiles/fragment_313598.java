Class clazz = Class.forName("net.something.EnumB");
Method nameMethod = clazz.getMethod("name");
Object value = null;
Object[] enums = clazz.getEnumConstants();

for (Object o : enums) {
    if (nameMethod.invoke(o).equals("SUBTITLE")) {
        value = o;
        break;
    }
}
Class.forName("net.something.ClassA").getConstructors()[1].newInstance
    (value, "Test");