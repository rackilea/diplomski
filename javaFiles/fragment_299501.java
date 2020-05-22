List resultWithAliasedBean = s.createSQLQuery(
  "SELECT st.name as studentName, co.description as courseDescription " +
  "FROM Enrolment e " +
  "INNER JOIN Student st on e.studentId=st.studentId " +
  "INNER JOIN Course co on e.courseCode=co.courseCode")
  .addScalar("studentName")
  .addScalar("courseDescription")
  .setResultTransformer( Transformers.aliasToBean(StudentDTO.class))
  .list();

StudentDTO dto =(StudentDTO) resultWithAliasedBean.get(0);