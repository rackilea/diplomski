public void fetchData()
{
    db = new DataBaseHelper(getContext());
    try {

        db.createDataBase();
        db.openDataBase();

    }
    catch (Exception e)
    {
        e.printStackTrace();
    }

    namelist = new LinkedHashMap<>();
    nmlist = new LinkedHashMap<>();
    int ii;
    SQLiteDatabase sd = db.getReadableDatabase();
    Cursor cursor = sd.query("dictionary_lib" ,new String[]{
            "English_lib", "German_lib", "rowid"
    }, null, null, null, null, null);
    ii=cursor.getColumnIndexOrThrow("rowid");
    eng_list = new ArrayList<String>();
    ger_list = new ArrayList<String>();
    id_list = new ArrayList<String>();
    while (cursor.moveToNext()){
        namelist.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndexOrThrow("English_lib")));
        nmlist.put(cursor.getString(ii), cursor.getString(cursor.getColumnIndexOrThrow("German_lib")));
    }

    Iterator entries = namelist.entrySet().iterator();
    Iterator entrs = nmlist.entrySet().iterator();
    while (entries.hasNext() && entrs.hasNext()) {
        Map.Entry thisEntry = (Map.Entry) entries.next();
        Map.Entry altEntry = (Map.Entry) entrs.next();
        id_list.add(String.valueOf(thisEntry.getKey()));
        eng_list.add(String.valueOf(thisEntry.getValue()));
        ger_list.add(String.valueOf(altEntry.getValue()));
    }

    for (int i = 0; i < id_list.size(); i++) {
        data.add(new DictObjectModel(eng_list.get(i), ger_list.get(i)));
    }
    adapter = new CustomAdapter(data);
    rv.setAdapter(adapter);
}