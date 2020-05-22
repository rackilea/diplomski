Student student = new Student("firstName", "lastName");
Map<String, Object> values = student.toMap();

queryToGetData = FirebaseDatabase.getInstance().getReference()
    .child(AppData.STUDENTS).child(user.getUid())
    .updateChildren(values);