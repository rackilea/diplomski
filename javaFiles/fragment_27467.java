for (int i = 0; i < maxId; i++) {

        double tmp = Integer.parseInt(cursor.getString(0));
        sum = sum + tmp;
        cursor.moveToNext();
    }