public void updateQty(Integer qty,String bookId)
 {
   int originalQty = getQuantity(bookId);
   int updateQty = originalQty - qty;
try{
    SQLiteDatabase db = this.getWritableDatabase();
    String rawQuery = "update " + BOOKS_TABLE + " set " + KEY_QTY + " = " + updateQty + " where " + KEY_BOOK_ID + " = '" + bookId + "';";

    db.execSQL(rawQuery);
    db.close();
    Log.v("UpdateQty", "Qty updated");
}
catch(Exception ex)
{
    ex.printStackTrace();
}
}