if (propertyEditor != null && !(value instanceof String)) {
    try {
        propertyEditor.setValue(value);
        return getDisplayString(propertyEditor.getAsText(), htmlEscape);
    }
    catch (Throwable ex) {
        // The PropertyEditor might not support this value... pass through.
        return getDisplayString(value, htmlEscape);
    }
}
else {
    return getDisplayString(value, htmlEscape);
}