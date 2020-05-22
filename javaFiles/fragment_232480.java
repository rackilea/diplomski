public void deleteInformation(String  year, String semester, 
            String grade, String course, String points){
    SQLiteDatabase db = null;
    try
    {
         db = this.getWritableDatabase();

         String where = UserCourse.NewCourseInfo.YEAR + " = ? AND "
                  + UserCourse.NewCourseInfo.SEMESTER + " = ? AND "
                  + UserCourse.NewCourseInfo.COURSE + " = ? AND "
                  + UserCourse.NewCourseInfo.POINTS + " = ? AND "
                  + UserCourse.NewCourseInfo.GRADE + " = ?";

         int iNumberDeleted = db.delete(
                               UserCourse.NewCourseInfo.TABLE_NAME, 
                               where,
                      new String[]{year, semester, course, points, grade}
                               );
        // you might want to evaluate the number of affected rows
    }
    catch (Exception ex)
    {
        Log.d("DB_DELETE", "...your data..." + "\n" + ex.getMessage());

    }
    finally
    {
        if (db != null)
            db.close();
    }



}