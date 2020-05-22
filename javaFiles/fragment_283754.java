List<DAO<?, ?>> knownDAOs = ...

for (DAO<?, ?> daoImpl : knownDAOs) {
    Type[] types = resolveActualTypeArgs(daoImpl.getClass(), DAO.class);
    boolean canReadPerson = types[1] instanceof Class<?> && Person.class.isAssignableFrom((Class<?>) types[1]);
}