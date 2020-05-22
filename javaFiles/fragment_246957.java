protected void _addSerializer(Class<?> cls, JsonSerializer<?> ser)
{
    ClassKey key = new ClassKey(cls);
    // Interface or class type?
    if (cls.isInterface()) {
        if (_interfaceMappings == null) {
            _interfaceMappings = new HashMap<ClassKey,JsonSerializer<?>>();
        }
        _interfaceMappings.put(key, ser);
    } else { // nope, class:
        if (_classMappings == null) {
            _classMappings = new HashMap<ClassKey,JsonSerializer<?>>();
        }
        _classMappings.put(key, ser);
        if (cls == Enum.class) {
            _hasEnumSerializer = true;
        }
    }
}