public long insertWorkDetails(String project, String workDescription, String per,String timeIn,String timeOut,String totalHours, long id)
{
    database=dbHelper.getWritableDatabase();
    ContentValues values=new ContentValues();
    values.put(MyDatabaseHelper.Project,project);
    values.put(MyDatabaseHelper.WorkDescription,workDescription);
    values.put(MyDatabaseHelper.Per,per);
    values.put(MyDatabaseHelper.TimeIn,timeIn);
    values.put(MyDatabaseHelper.TimeOut,timeOut);
    values.put(MyDatabaseHelper.TotalHours, totalHours);
    values.put("TableInfo_id", id);
    database.insert(MyDatabaseHelper.TABLE_WORKDETAILS,null,values);
    database.close();
    return 0 ;

}