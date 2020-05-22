CriteriaBuilder builder = em.getCriteriaBuilder();
CriteriaQuery<LectureCourse> criteria = builder.createQuery(LectureCourse.class);
Root<Lecturer> l = criteria.from(Lecturer.class);
Path<Course> c = l.join(Lecturer_.courses);
ParameterExpression<String> l_id = builder.parameter(String.class);
Predicate lecturerIdMatches = builder.equal(l.get(Lecturer_.id),l_id);
TypedQuery<LectureCourse> query = em.createQuery(criteria.multiselect(l.get(Lecturer_.id), l.get(Lecturer_.name), l.get(Lecturer_.surName), l.get(Lecturer_.type), c.get(Course_.code), c.get(Course_.name)).where(lecturerIdMatches));

query.setParameter(l_id,"queryvalue");
List<LectureCourse> results = query.getResultList();