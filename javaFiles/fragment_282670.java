em.getTransaction().begin();
 School schoolObj = new School();
 schoolObj.setName("School 1");
 List <Teacher> teachers = new ArrayList<Teacher>();
 List <Workshop> workshopList = new ArrayList<Workshop>();
 Teacher teacher = new Teacher(); 
teacher.setSchool(schoolObj);
 teacher.setName("Teacher 1");
 teachers.add(teacher);
Teacher teacher1 = new Teacher();
 teacher1.setSchool(schoolObj); 
teacher1.setName("Teacher 2"); 
teachers.add(teacher1); 
teacher teacher2 = new Teacher();
 teacher2.setSchool(schoolObj);
 teacher2.setName("Teacher 3");
 teachers.add(teacher2); 
Workshop ws = new Workshop();
ws.setSchool(schoolObj); //By this you setted schoolObj in workshop entity
ws.set(some attribute);
workshopList.add(ws);
school.setTeachers(teachers); //By this you setted teachers through school ,i.e., entry came in teachers table too.
school.setWorkshops(workshopList); //By this you setted workshopList through school ,i.e., entry came in workshop table too.
em.persist(schoolObj); 
em.getTransaction().commit();
 em.close();