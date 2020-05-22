SQLiteDatabase db  =null;//Initialize this first
    Cursor cursor = db.rawQuery("your query", null);//Replace with your query(e.g. SELECT FROM table WHERE something=2)
    String preChanged = cursor.getString(cursor.getColumnIndex("row_name"));//Replace row name with your row name
    String[] finalR = preChanged.split(",");//Can be changed to parts
    //String[] finalR = new String[parts.length];
    //for(int i = 0; i < parts.length; i++){
    //    finalR[i] = parts[i];//This for-loop is if you have special needs. If you want to convert the String to a different type(integer, boolean, etc), or you want to make sure it contains/does not contain something.
    //}//Uncomment if needed

    //Now, this needs a special compression method, to ensure correct format;
    //raw is the raw array, continuing from up above we use finalR to make sure you as a reader understand the context

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < finalR.length; i++) {
        if(i != finalR.length - 1)
            builder.append(finalR[i] + ",");
        else
            builder.append(finalR[i]);
    }