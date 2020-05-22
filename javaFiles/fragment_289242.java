interface HasProperty<T> {
    T getProperty();
}

public static <T> List<T> getProperties(List<? extends HasProperty<T>> items) {
    List<T> properties = new ArrayList<T>();
    for (HasProperty<T> item : items) {
        properties.add(item.getProperty());
    }
    return properties;
}