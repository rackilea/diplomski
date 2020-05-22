public static <T> int deleteAllEntities(Class<T> entityType) {
    String query = new StringBuilder("DELETE FROM ")
                            .append(entityType.getSimpleName())
                            .append(" e")
                            .toString();
    return em.createQuery(query).executeUpdate();
}

public static <T> int truncateTable(Class<T> entityType) {
    String query = new StringBuilder("TRUNCATE TABLE ")
                            .append(entityType.getSimpleName())
                            .toString();        
    return em.createNativeQuery(query).executeUpdate();
}