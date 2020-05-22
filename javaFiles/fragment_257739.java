public <T extends Car> void addRow(List<T> list) throws InstantiationException,
        IllegalAccessException {
    T element = list.get(list.size() - 1);
    @SuppressWarnings("unchecked")
    Class<T> clazz = (Class<T>) element.getClass();
    T newInstance = clazz.newInstance();
    list.add(newInstance);
}