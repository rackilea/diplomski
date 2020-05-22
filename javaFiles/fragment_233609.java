// assuming you have already the anonymous class name
Class<?> anonymousClassType = Class.forName("Wrirter$1");

// get the declared fields of the anonymous class
Field[] declaredFields = anonymousClassType.getDeclaredFields();
for (Field field : declaredFields) {
        System.out.printf("type: %s  name: %s%n",
                field.getType(),
                field.getName()
        );
}