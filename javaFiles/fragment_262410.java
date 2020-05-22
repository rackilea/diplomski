@PersistenceContext
private EntityManager em;

public String getValue() throws NotSupportedException, SystemException {
        EmployeesEntity emp = em.find(EmployeesEntity.class, 207);

        return emp.getLAST_NAME();
}