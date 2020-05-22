List<String> properties = new ArrayList<String>();
Class<?> cl = MyBean.class;

// check all declared fields
for (Field field : cl.getDeclaredFields()) {

    // if field is private then look for setters/getters
    if (Modifier.isPrivate(field.getModifiers())) {

        // changing 1st letter to upper case
        String name = field.getName();
        String upperCaseName = name.substring(0, 1).toUpperCase()
                + name.substring(1);
        // and have getter and setter
        try {
            String simpleType = field.getType().getSimpleName();
            //for boolean property methods should be isProperty and setProperty(propertyType)
            if (simpleType.equals("Boolean") || simpleType.equals("boolean")) {
                if ((cl.getDeclaredMethod("is" + upperCaseName) != null)
                        && (cl.getDeclaredMethod("set" + upperCaseName,
                                field.getType()) != null)) {
                    properties.add(name);
                }
            } 
            //for not boolean property methods should be getProperty and setProperty(propertyType)
            else {
                if ((cl.getDeclaredMethod("get" + upperCaseName) != null)
                        && (cl.getDeclaredMethod("set" + upperCaseName,
                                field.getType()) != null)) {
                    properties.add(name);
                }
            }
        } catch (NoSuchMethodException | SecurityException e) {
            // if there is no method nothing bad will happen
        }
    }
}
for (String property:properties)
    System.out.println(property);