// Create CriteriaBuilder
CriteriaBuilder builder = session.getCriteriaBuilder();

// Create CriteriaQuery
CriteriaQuery<Student> criteria = builder.createQuery(Student.class);

// Set root
Root<Student> root = criteria.from(Student.class);
criteria.select(root);

// Query execution
Query<Item> query = session.createQuery(criteria);
List<Item> results = query.getResultList();