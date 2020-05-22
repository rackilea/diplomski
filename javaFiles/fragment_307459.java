List<Student> students = new ArrayList<Student>();

BasicDBObject query = new BasicDBObject();
query.put("user", username); 
DBCursor cursor = theCollection.find(query); 
while (cursor.hasNext()) {
    DBObject theObj = cursor.next();
    //How to get the DBObject value to ArrayList of Java Object?

    BasicDBList studentsList = (BasicDBList) theObj.get("students");
    for (int i = 0; i < studentsList.size(); i++) {
        BasicDBObject studentObj = (BasicDBObject) studentsList.get(i);
        String firstName = studentObj.getString("firstName");
        String lastName = studentObj.getString("lastName");
        String age = studentObj.getString("age");
        String gender = studentObj.getString("gender");

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);
        student.setGender(gender);

        students.add(student);
    }               
}