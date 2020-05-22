String query = "SELECT e FROM Employee e WHERE :meeting MEMBER OF e.meetings";

Meeting meeting = new Meeting();
meeting.setId(1);

TypedQuery<Employee> query = em.createQuery(query, Employee.class);
List<Employee> employeesInMeeting = query.setParameter("meeting", meeting).getResultList();  
// this will select all employees that has a meeting with id=1 in their list