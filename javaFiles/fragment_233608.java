// the outer class type
Class<?> forName = Wrirter.class;

// instance to investigate
Wrirter outerClass = new Wrirter();

// call the method which create an object of the anonymous class
outerClass.ann();

// get the field which holds a reference to the anonymous class
Field fieldAnonymousClass = forName.getDeclaredField("c");

// get the reference to the anonymous class
Object instanceAnonymousClass = fieldAnonymousClass.get(outerClass);

// get the class type of the anonymous class
Class anonymousClassType = instanceAnonymousClass.getClass();
System.out.println("anonymous class name: " + anonymousClassType.getName());

// get the declared fields of the anonymous class
Field[] declaredFields = anonymousClassType.getDeclaredFields();
for (Field field : declaredFields) {
    if (field.getType() == int.class) {
        // print the field name and its value
        System.out.printf("name: %s  value: %s%n",
                field.getName(),
                field.getInt(instanceAnonymousClass)
        );
    }
}