//for each field declared in User,
for (Field field : User.class.getDeclaredFields()) {
    //get the static type of the field
    Class<?> fieldType = field.getType();
    //if it's String,
    if (fieldType == String.class) {
        // save/use field
    }
    //if it's String[],
    else if (fieldType == String[].class) {
        // save/use field
    }
    //if it's List or a subtype of List,
    else if (List.class.isAssignableFrom(fieldType)) {
        //get the type as generic
        ParameterizedType fieldGenericType =
                (ParameterizedType)field.getGenericType();
        //get it's first type parameter
        Class<?> fieldTypeParameterType =
                (Class<?>)fieldGenericType.getActualTypeArguments()[0];
        //if the type parameter is String,
        if (fieldTypeParameterType == String.class) {
            // save/use field
        }
    }
}