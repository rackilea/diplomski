BasicDBObject searchQuery = new BasicDBObject("loginid", username);
BasicDBObject theUserObj = new BasicDBObject();

List<Object> studentsDBList = new BasicDBList();

for (Student student : studentArray) {
    DBObject studentDBObject = new BasicDBObject();
    studentDBObject.put("firstName", student.getFirstName());
    studentDBObject.put("lastName", student.getLastName());
    studentDBObject.put("age", student.getAge());
    studentDBObject.put("gender", student.getGender());
    studentsDBList.add(studentDBObject);
} 

theUserObj.put("phone", profile.phone);
theUserObj.put("students", studentsDBList);

theUserCollection.update(searchQuery, theUserObj);