/**
 * @return true if the parameter is annotated with {@link ModelAttribute}
 * or in default resolution mode also if it is not a simple type.
 */
@Override
public boolean supportsParameter(MethodParameter parameter) {
    if (parameter.hasParameterAnnotation(ModelAttribute.class)) {
        return true;
    }
    else if (this.annotationNotRequired) {
        return !BeanUtils.isSimpleProperty(parameter.getParameterType());
    }
    else {
        return false;
    }
}