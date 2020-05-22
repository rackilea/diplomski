SparseArray<Data> dataArray = new SparseArray<Data>();
    cursor.moveToFirst();
    do {
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String title = cursor.getString(cursor.getColumnIndex("TITLE"));
        String topic = cursor.getString(cursor.getColumnIndex("TOPIC"));
        String type = cursor.getString(cursor.getColumnIndex("TYPE"));
        String name = cursor.getString(cursor.getColumnIndex("NAME"));
        Data d = dataArray.get(id);
        if (d == null) {
            d = new Data(id, title, topic, type);
            d.names.add(name);
            dataArray.put(id, d);
        } else {
            d.names.add(name);
        }
    } while (cursor.moveToNext());


// now you can get names like this
    for (int i = 0; i < dataArray.size(); i++) {
        Data d = dataArray.get(i);
        String names = TextUtils.join(" ", d.names); 
    }