public void exportExcelSheet() {
    DatabaseHandler mDbHandler = new DatabaseHandler(mActivity);
    File exportDir = new File(Environment.getExternalStorageDirectory(), "");
    if (!exportDir.exists()) {
        exportDir.mkdirs();
    }

    File file = new File(exportDir, "Report.csv");

    // ============== CHANGE ==============
    if (!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String[] ColumnNames = {"Roll No.", "Name", "LA", "LT", "% age"};

    // ============== CHANGE ==============
    CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
    csvWrite.writeNext(ColumnNames);

    String studentInfoQuery = "SELECT * FROM StudentList";
    Cursor studentsListCursor = mDbHandler.execQuery(studentInfoQuery);

    studentsListCursor.moveToFirst();

    // ============== CHANGE ==============
    do {
        String AttendanceListQuery = "SELECT * FROM AttendanceSheet WHERE StudRoll = '" + studentsListCursor.getPosition() + "';";
        String AttendanceQuery = "SELECT * FROM AttendanceSheet WHERE StudRoll = '" + studentsListCursor.getPosition() + "' AND isPresent = 1";


        int attendancePercent = 0;
        Cursor totalClasses = mDbHandler.execQuery(AttendanceListQuery);
        Cursor attendedClasses = mDbHandler.execQuery(AttendanceQuery);

        if (totalClasses == null) {
            Log.d("profile", "totalClasses null");
        }

        if (attendedClasses == null) {
            Log.d("profile", "attendedClasses null");
        }

        if (totalClasses != null && attendedClasses != null) {
            totalClasses.moveToFirst();
            attendedClasses.moveToFirst();

            try {
                attendancePercent = (int) (((float) attendedClasses.getCount() / totalClasses.getCount()) * 100);
            } catch (Exception e) {
                attendancePercent = -1;
            }
        }

        assert attendedClasses != null;
        assert totalClasses != null;
        String showAttendedLectures = String.valueOf(attendedClasses.getCount());
        String showTotalLectures = String.valueOf(totalClasses.getCount());
        //String showMissedLectures = String.valueOf(totalClasses.getCount() - attendedClasses.getCount());
        String AttendancePercentage = String.valueOf(attendancePercent);

        try {
            String[] arrStr = {studentsListCursor.getString(1), studentsListCursor.getString(0), showAttendedLectures, showTotalLectures, AttendancePercentage + " %"};
            csvWrite.writeNext(arrStr);
            // ============== CHANGE ==============
            // studentsListCursor.moveToNext();
        } catch (Exception sqlException) {
            Toast.makeText(mActivity, "FAILED", Toast.LENGTH_SHORT).show();
            Log.e("MainActivity", sqlException.getMessage(), sqlException);
        }

        Toast.makeText(mActivity, "Saved", Toast.LENGTH_SHORT).show();
    }
    // ============== CHANGE ==============
    while (studentsListCursor.moveToNext());

    csvWrite.close();
}