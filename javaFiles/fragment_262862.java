CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Phone> criteriaQuery = cb.createQuery(Phone.class);
Root<Employee> employee = criteriaQuery.from(Employee.class);
CollectionJoin<Employee, Phone> phone = employee.join(Employee_.phones);
criteriaQuery.where(cb.equal(employee, empl);
criteriaQuery.select(phone);
TypedQuery<Phone> query = em.createQuery(criteriaQuery);
List<Phone> phones = query.getResultList();