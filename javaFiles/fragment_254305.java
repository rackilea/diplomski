Cursor cursor = sqlDB.query(TaskContract.TABLE, // <-- open parenthesis
                new String[]{TaskContract.Columns._ID, TaskContract.Columns.TASK, TaskContract.Columns.TEXT },
                null, null, null, null, null); // <-- close parenthesis with semi-colon. Cursor has been defined. 
                new Boolean []{TaskContract.Columns.FAVOURITE}, // <-- unexpected token error here
                null, null, null); // <-- Additional close parenthesis
                new Integer []{TaskContract.Columns.DATE },
                null, null, null); // <-- I suspect this is where you meant to end the cursor?