checkBoxImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        DBHELPER dbhelper = new DBHELPER(context);
        SQLiteDatabase db = dbhelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        String[] columns = new String[]{DBHELPER.WISHLIST_COLUMN_NAME, DBHELPER.WISHLIST_COLUMN_GIFT, DBHELPER.WISHLIST_COLUMN_SPECIFICS, DBHELPER.WISHLIST_COLUMN_STORE, DBHELPER.WISHLIST_COLUMN_URL, DBHELPER.WISHLIST_COLUMN_STATUS};
        Cursor cursor2 =  db.query(DBHELPER.WISHLIST_TABLE_NAME, columns, null, null, null, null, null);

        String status2 = cursor2.getString(cursor2.getColumnIndex(DBHELPER.WISHLIST_COLUMN_STATUS));

        if("true".equals(status2)) {
            values.put(DBHELPER.WISHLIST_COLUMN_NAME, name2);
            values.put(DBHELPER.WISHLIST_COLUMN_GIFT, gift);
            values.put(DBHELPER.WISHLIST_COLUMN_SPECIFICS, specs);
            values.put(DBHELPER.WISHLIST_COLUMN_STORE, store);
            values.put(DBHELPER.WISHLIST_COLUMN_URL, url);
            values.put(DBHELPER.WISHLIST_COLUMN_STATUS, "false");

            db.update(DBHELPER.WISHLIST_TABLE_NAME, values,"_ID " + "='" + id + "'", null);
            Message.message(context, "FALSE UPDATED");

            ImageButton checkBoxImage = (ImageButton) v.findViewById(R.id.ID_ROW_CHECKBOX);
            checkBoxImage.setImageResource(R.drawable.icon_no);
        } else {
            values.put(DBHELPER.WISHLIST_COLUMN_NAME, name2);
            values.put(DBHELPER.WISHLIST_COLUMN_GIFT, gift);
            values.put(DBHELPER.WISHLIST_COLUMN_SPECIFICS, specs);
            values.put(DBHELPER.WISHLIST_COLUMN_STORE, store);
            values.put(DBHELPER.WISHLIST_COLUMN_URL, url);
            values.put(DBHELPER.WISHLIST_COLUMN_STATUS, "true");

            ImageButton checkBoxImage = (ImageButton) v.findViewById(R.id.ID_ROW_CHECKBOX);
            checkBoxImage.setImageResource(R.drawable.icon_yes);

            System.out.println("BEFORE : " + status2);
            db.update(DBHELPER.WISHLIST_TABLE_NAME, values,"_ID " + "='" + id + "'", null);
            Message.message(context, "TRUE UPDATED");
        }

        db.close();
    }
});