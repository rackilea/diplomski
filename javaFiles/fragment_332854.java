Cursor c = database.query("names", null, null, null, null, null, null);
        c.moveToFirst();
        String name;
        do{
            int nameCI = c.getColumnIndex("name");
            name = c.getInt(nameCI);
        }while (c.moveToNext());