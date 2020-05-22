public List<Tuple> findEmployeeList(Integer id)
{
    em = getEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Tuple> cq = cb.createTupleQuery();
    Root<Addemp> empRoot = cq.from(Addemp.class);
    Root<Job> jobRoot = cq.from(Job.class);
    cq.multiselect(empRoot.get("empId").alias("id"), 
                   empRoot.get("firstName").alias("first"),
                   empRoot.get("lastName").alias("last"),
                   jobRoot.get("jobTitle").alias("title"),
                   jobRoot.get("empStatus").alias("status"),
                   jobRoot.get("subUnit").alias("subunit"));
    cq.where(cb.equal(empRoot.get("empId"), id));

    TypedQuery<Tuple> q = em.createQuery(cq);
    return q.getResultList();
}