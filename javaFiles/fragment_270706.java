if(cursor.moveToFirst()){
    do {
        String[] record = new String[count];
        for (int i = 0; i < count; i++) {
            record[i] = cursor.getString(i);
        }
        list.add(record);
    }while (cursor.moveToNext());
}