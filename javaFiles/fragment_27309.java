public String getString(Enum<?> value) {
    Class<?> enclosingClass = value.getClass().getEnclosingClass();
    String key = (enclosingClass == null ? "" : enclosingClass.getSimpleName() + ".")
            + value.getClass().getSimpleName() + "." + value.name();
    return getString(key);
}