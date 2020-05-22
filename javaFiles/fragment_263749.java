// ====  Determine target type  =====
final Class<? extends StringConvertible> targetClass;
{
    // ====  Get the contextual type info  =====
    final JavaType type; 
    if (beanProperty != null) 
        type = beanProperty.getType();  // -> beanProperty is null when the StringConvertible type is a root value

    else {
        type = deserializationContext.getContextualType();
    }

    // ====  Get raw Class from type info  =====
    targetClass = (Class<? extends StringConvertible>) type.getRawClass();
}