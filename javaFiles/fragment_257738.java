public <T extends Car> void addRow(List<T> list) throws InstantiationException,
        IllegalAccessException {
    T element = list.get(list.size() - 1);
    Class<T> clazz = element.getClass(); // Compilation Error Here!
    T newInstance = clazz.newInstance();
    list.add(newInstance);
}