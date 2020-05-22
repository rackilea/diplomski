@Override
public void updatePasswordByUsername(String username, String password) throws UserNameNotFoundException
{
    Query query = em.createQuery("SELECT e FROM Employee e WHERE e.username = :inUsername");
    query.setParameter("inUsername", username);
    //query.getSingleResult();

    Employee employee = (Employee) query.getSingleResult();
    employee.setPassword(password);
    em.persist(employee);    
}