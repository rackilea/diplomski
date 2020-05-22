public List<Project> getProjectsByEmployee(Long empId){
    String jpql = "SELECT emp FROM Employee e" +
                  "INNER JOIN FETCH e.projects" +
                  "WHERE emp.id=:empId";
    TypedQuery<Employee> query = em.createQuery(jpql, Employee.class)
                                         .setParameter("empId", empId);
    Employee emp = query.getSingleResult();
    return emp.getProjects();
}