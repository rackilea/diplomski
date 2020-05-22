public void update(long id, Map<String, Object> properties) {
    Object obj = getObjectById(id); // you have to implement that method
    for (String property : properties.keySet()) {
        Field field = obj.getClass().getField(property);
        field.set(obj, properties.get(property));
    }
}