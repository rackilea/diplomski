byte[] rawValue(Object value) {

    if (valueSerializer() == null && value instanceof byte[]) {
        return (byte[]) value;
    }

    return valueSerializer().serialize(value);
}