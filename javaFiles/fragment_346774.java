public void additems(View view){

String sem=semorclass.getText().toString();
grade_db_helper=new Db_operation_helper(context);
sqLiteDatabase=grade_db_helper.getWritableDatabase();

    grade_db_helper.grade_add(sem, sqLiteDatabase);
    Toast.makeText(getBaseContext(), "Data is saved", Toast.LENGTH_LONG).show();
    grade_db_helper.close();
    finish();
}