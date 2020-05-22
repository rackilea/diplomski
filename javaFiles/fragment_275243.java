Query query2 = em
   .createQuery("FROM Semester s, IN (s.lesson) l, IN(l.lessonTeacher) lT1, lT1.teacher t WHERE t.lastname = :lastname");
query.setParameter("lastname", "Spooner");
List<Semester> resultList2 = query.getResultList(); 
for(Semester s : resultList2){
    System.out.println(s.getname());
}