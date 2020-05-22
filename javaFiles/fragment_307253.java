public <E> Object getDAOForEntity(Class<E> c) {
    try {
        // ...
    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        return new MyDAO<Integer,E>(emfa) {};
    }
}