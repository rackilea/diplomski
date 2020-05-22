public List<Student> getData() {
    List<Student> studentList = new ArrayList<Student>();
    // Select All Query
    String selectQuery = "SELECT  * FROM " + Table;

    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    // looping through all rows and adding to list
    if (cursor.moveToFirst()) {
        do {
            Student student = new Student();
            student.name = cursor.getString(0);
            student.gender = cursor.getString(1);
            student.age = Integer.parseInt(cursor.getString(2));
            student.password = cursor.getString(3);
            student.course = cursor.getString(4);
            student.modules = cursor.getString(5);
            studentList.add(student);
        } while (cursor.moveToNext());
    }

    // return contact list
    return studentList;
}