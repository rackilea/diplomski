@Override
public Boolean hasAsValue(Annotated a) {
    JsonValue ann = _findAnnotation(a, JsonValue.class);
    if (ann == null) {
        return null;
    }
    return ann.value();
}