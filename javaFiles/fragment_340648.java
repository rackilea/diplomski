Student s = new Student();
s.setCountry(hostSearchHistory.getCountry());
s.setCity(hostSearchHistory.getCity());
...
StudentDetails sd = new StudentDetails();
sd.setDrivingLicense(hostSearchHistory.getDrivingLicense());
sd.setSmoker(hostSearchHistory.getSmoker());
...

Criteria crit = session.createCriteria(Student.class);
crit.add(Example.create(s));
crit.createCriteria("studentDetails").add(Example.create(sd));
List<Student> studentList = crit.list();