public List<DepartmentType> getAllDepartmentTypes() {
    CriteriaBuilder builder = session.getCurrentSession().getCriteriaBuilder();
    CriteriaQuery<DepartmentType> criteriaQuery = builder.createQuery(DepartmentType.class);    
    Root<DepartmentType> deptType = criteriaQuery.from(DepartmentType.class);
    criteriaQuery.select(deptType).orderBy(builder.asc(deptType.get("department_type_name")));
    return session.getCurrentSession()
                .createQuery(criteriaQuery)
                .getResultList();
}