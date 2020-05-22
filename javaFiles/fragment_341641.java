String whereclause = "course_id=? OR semester_id=? OR level_id=? OR level_code=? or grade=?";
String[] whereargs = new String[]{"0","0","0","Select level", "Grade"};
Cursor cursor = mDatabase.query(
    "COURSES",
    null, //<<<< all columns (else String[] of columns)
    whereclause, //<<<< WHERE clause without the WHERE keyword
    whereargs, //<<<< arguments to replace ?'s 
    null, //<<<< GROUP BY clause
    null, //<<<< HAVING clause
    null //<<<< ORDER BY clause   
);