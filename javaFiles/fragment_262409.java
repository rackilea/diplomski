@PersistenceUnit(unitName="jobApplication")
private EntityManagerFactory emf;

public String getValue() throws NotSupportedException, SystemException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jobApplication");
        EntityManager em = emf.createEntityManager();
        EmployeesEntity emp = em.find(EmployeesEntity.class, 207);

        return emp.getLAST_NAME();
}