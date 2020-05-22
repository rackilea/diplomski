public class Example{

  // Getting contacts Count
    public int getContactsCount() {

    helper = new DBHelper(CheckTable.this);
    SQLiteDatabase db = helper.getReadableDatabase();

    String countQuery = "SELECT  * FROM " + Market.TABLE;

    Cursor cursor = db.rawQuery(countQuery, null);
    cursor.close();

    // return count
    return cursor.getCount();
}


 public static void main(String[] args) { //main method
    int a= getContactsCount(); //calling the method
    System.out.println(a);  //displaying the integer
}
}