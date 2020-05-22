inline fun <T : Annotation>findAnnotatedFields(
    annotation: Class<T>,
    clazz : Class<*>,
    onFind : (Field) -> Unit
){

    for(field in clazz.declaredFields){

        if(field.getAnnotation(annotation)!=null){

            field.isAccessible = true

            onFind(field)
        }
    }
}