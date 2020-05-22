//insert first edittext value
values.put(TaskContract.Columns.TASK, task); 
db.insertWithOnConflict(TaskContract.TABLE, null, values,SQLiteDatabase.CONFLICT_IGNORE);

values.clear();

//insert seco edittext value
values.put(TaskContract.Columns.TASK, task2);
db.insertWithOnConflict(TaskContract.TABLE, null, values,SQLiteDatabase.CONFLICT_IGNORE);