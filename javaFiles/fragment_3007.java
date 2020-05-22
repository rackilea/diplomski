A a = new A();
B b = new B();

a.field1 = 1;
a.field2 = 3;

for (Field aField : a.getClass().getDeclaredFields()) {
    try {
        Field bCounterpart = b.getClass().getDeclaredField(aField.getName());
        if (bCounterpart.getType().equals(aField.getType())) { // Doesn't work well with autoboxing etc. The types have to explictly match
            bCounterpart.setAccessible(true); // Only for private fields
            aField.setAccessible(true); // Only for private fields
            bCounterpart.set(b, aField.get(a));
        }
    } catch (NoSuchFieldException e) {
        // B doesn't have the field
    }
}

System.out.println(b.field2); // 3
System.out.println(b.field6); // 0