public static Specification<Student> withTeacherAndName(){
  return new Specification<Student>() {

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery,
        CriteriaBuilder criteriaBuilder) {

      List<Predicate> predicates = new ArrayList<>();
      predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(Student_.age), 20));


      Subquery<String> sq1 = criteriaQuery.subquery(String.class);
      Root<Classroom> classroomRoot = sq1.from(Classroom.class);
      sq1.select(classroomRoot.get(Classroom_.classroomId));
      sq1.where(criteriaBuilder.equal(classroomRoot.get(Classroom_.teacher), "Marta"));

      Subquery<String> sq2 = criteriaQuery.subquery(String.class);
      Root<Classroom> classroomRoot2 = sq2.from(Classroom.class);
      sq2.select(classroomRoot2.get(Classroom_.classroomId));
      sq2.where(criteriaBuilder.equal(classroomRoot2.get(Classroom_.teacher), "Fowler"));

      criteriaQuery.where(criteriaBuilder.equal(root.get(Student_.classroomId), sq1));
      criteriaQuery.where(criteriaBuilder.equal(root.get(Student_.classroomId), sq2));

      return criteriaBuilder.and(predicates.toArray(new Predicate[]{}));
    }
  };
}