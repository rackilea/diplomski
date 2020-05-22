Cursor cursor = db.query(TABLE_FORMATS,
                         new String[] { whatever columns you need },
                         "OrderID = " + orderID,
                         null, null, null, null, null);
while (cursor.moveToNext()) {
    // read one order from the cursor
}
cursor.close();