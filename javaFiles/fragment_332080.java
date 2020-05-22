public boolean addEmployees(List<Employee> employees) { 
    SQLiteDatabase database = this.getWritableDatabase();
    for (Employee e : employees) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, e.getEmployee_number());
        ...

        database.insert(TABLE_EMPLOYEE, null, values);       
    }
    database.close();
    return true;
}