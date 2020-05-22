public class EmployeeDatabaseHelper {
DatabaseHelper dbhelper;

public EmployeeDatabaseHelper(Context applicationContext) {
    dbhelper= new DatabaseHelper(applicationContext);
}

public long insertEmployee(String name, String username, String password){
    SQLiteDatabase db = dbhelper.getWritableDatabase();
    ContentValues cv = new ContentValues();
    cv.put(EMPLOYEE_NAME,name);
    cv.put(EMPLOYEE_USERNAME,username);
    cv.put(EMPLOYEE_PASSWORD,password);
    long id = db.insert(TABLE_NAME_EMPLOYEE, null, cv);
    db.close();
    return id;      
}

public ArrayList<Employee> getAllEmployee(){

    ArrayList<Employee> employeeArrayList = new ArrayList<Employee>();
    SQLiteDatabase db = dbhelper.getWritableDatabase();
    Cursor cursor = db.query(TABLE_NAME_EMPLOYEE, null,null,null,null,null,null);

        while (cursor.moveToNext()) {
            Employee e  = new Employee();
            e.name = cursor.getString(cursor.getColumnIndex(EMPLOYEE_NAME));
            e.username = cursor.getString(cursor.getColumnIndex(EMPLOYEE_USERNAME));
            employeeArrayList.add(e);
        } 

    db.close();
    return employeeArrayList;
}
}