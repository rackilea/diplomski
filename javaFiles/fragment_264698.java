public class UniqueKeyValidator implements ConstraintValidator<UniqueKey, Serializable>, EntityManagerAwareValidator {

    private EntityManager entityManager;

    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private String[] columnNames;

    @Override
    public void initialize(UniqueKey constraintAnnotation) {
        this.columnNames = constraintAnnotation.columnNames();

    }

    @Override
    public boolean isValid(Serializable target, ConstraintValidatorContext context) {
        Class<?> entityClass = target.getClass();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

        Root<?> root = criteriaQuery.from(entityClass);

        List<Predicate> predicates = new ArrayList<Predicate> (columnNames.length);

        try {
            for(int i=0; i<columnNames.length; i++) {
                String propertyName = columnNames[i];
                PropertyDescriptor desc = new PropertyDescriptor(propertyName, entityClass);
                Method readMethod = desc.getReadMethod();
                Object propertyValue = readMethod.invoke(target);
                Predicate predicate = criteriaBuilder.equal(root.get(propertyName), propertyValue);
                predicates.add(predicate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        TypedQuery<Object> typedQuery = entityManager.createQuery(criteriaQuery);

        List<Object> resultSet = typedQuery.getResultList(); 

        return resultSet.size() == 0;
    }

}