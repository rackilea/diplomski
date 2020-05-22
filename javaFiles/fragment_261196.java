public ArrayList getInventory() {
    db = SQLiteDatabase.openDatabase("/data/data/com.sjhdevelopment.shaunharrison.myejuiceapp/databases/EJuiceData.db", null, 0);
    Cursor c = db.rawQuery("SELECT * FROM Inventory", null);
    List InventoryList = new ArrayList();
    if (c.moveToFirst()) {
        do {
            Double amountLeft = Double.parseDouble(c.getString(4));
            if (amountLeft != 0) {
                InventoryList.add(c.getString(1));
            }
        } while (c.moveToNext());
    }
    java.util.Collections.sort(InventoryList);
    InventoryList.add(0, "No Selection");

    return InventoryList;
}