public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    Page page = new Page();
    Collection<Field> fields = getFieldsWithSuperclass(page.getClass(), BaseElement.class);
    for(Field field : fields) { //iterate over all fields found
        field.setAccessible(true);
        BaseElement fieldInstance = (BaseElement) field.get(pageCreated); //get the instance corresponding to the field from the given class instance
        fieldInstance.exists(); //call the method
    }
}

private static Collection<Field> getFieldsWithSuperclass(Class instance, Class<?> superclass) {
    Field[] fields = instance.getDeclaredFields(); //gets all fields from the class

    ArrayList<Field> fieldsWithSuperClass = new ArrayList<>(); //initialize empty list of fields
    for(Field field : fields) { //iterate over fields in the given instance
        Class fieldClass = field.getType(); //get the type (class) of the field
        if(superclass.isAssignableFrom(fieldClass)) { //check if the given class is a super class of this field
            fieldsWithSuperClass.add(field); //if so, add it to the list
        }
    }
    return fieldsWithSuperClass; //return all fields which have the fitting superclass
}