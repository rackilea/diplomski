public class BaseSQLite extends SQLiteOpenHelper{

    public static final String DBNAME = "mydatabase.db";
    public static final int DBVERSION = 1;
    public static final String TB_TICKETCAISSE = "TicketCaisse";
    public static final String COL_TICKETCAISSE_NBTICKET = "nbTicket"

    public BaseSQLite(Context context) {
        super(context,DBNAME,null,DBVERSION);
    }
    ......
    public List getNumTicket(){
        List NumTicket=new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COL_TICKETCAISSE_NBTICKET + " FROM " + TB_TICKETCAISSE;
        Cursor cursor = db.rawQuery(query, null);
        while(cursor.moveToNext()){
            NumTicket.add(cursor.getInt(csr.getColumnIndex(COL_TICKETCAISSE_NBTICKET)));
        }
        cursor.close() //<<<< ADDED should always close Cursors when done with them
        db.close();
        return NumTicket;
}