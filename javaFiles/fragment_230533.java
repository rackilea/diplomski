private boolean checkEmailExists(String email) {
        String query = "Select * from "+TABLE_NAME+" where email like '"+email+"'";


        Cursor cursor = db.rawQuery(query,
                null);
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }