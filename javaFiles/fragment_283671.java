// Loop through every class with Form annotation
    for (Class<? extends Forms> form : customForms) {
        for (Field field : form.getDeclaredFields()) {
            // Check each field, if it has your FormField attribute, you can then access the annotation methods
            if (field.isAnnotationPresent(FormField.class)) {
                Label label = new Label(field.getAnnotation(FormField.class).label());
                // Do additional stuff to build your form
            }
        }
    }