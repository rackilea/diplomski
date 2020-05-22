@NoRepositoryBean
@RequiredArgsConstructor
public class FindByFieldRepositoryImpl<T> implements FindByFieldRepository<T> {

    private final EntityManager manager;

    @Override
    public T findByField(String field, Object value, Class<T> clazz) {
        return createQuery(field, value, clazz).getSingleResult();
    }

    private TypedQuery<T> createQuery(String fieldName, Object fieldValue, Class<T> clazz) {
        JpaEntityInformation entityInformation = JpaEntityInformationSupport.getEntityInformation(clazz, manager);
        String entityName = entityInformation.getEntityName();
        Class<T> entityType = entityInformation.getJavaType();

        String queryString = String.format("FROM %s WHERE %s = :value", entityName, fieldName);
        TypedQuery<T> query = manager.createQuery(queryString, entityType);
        return query.setParameter("value", fieldValue);
    }
}