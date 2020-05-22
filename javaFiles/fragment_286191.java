public static Employee findEmployeesByNameEquals(String name) {
    if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
    EntityManager em = Employee.entityManager();
    TypedQuery<Employee> q = em.createQuery("SELECT o FROM Employee AS o WHERE o.name = :name", Employee.class);
    q.setParameter("name", name);
    return q.getSingleResult();
}