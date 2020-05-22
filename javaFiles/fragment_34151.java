public class DatabaseHandler extends SQLiteOpenHelper {

// All Static variables
// Database Version
private static final int DATABASE_VERSION = 1;

// Database Name
private static final String DATABASE_NAME = "scheduleManager";

// Contacts table name
private static final String TABLE_EVENTS = "events";


// Contacts Table Columns names
private static final String KEY_ID = "id";
private static final String KEY_TITLE = "title";
private static final String KEY_TIME = "time";
private static final String KEY_DATE = "date";
private static final int KEY_DRW = 0;

public DatabaseHandler(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
}

@Override
public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub
    String CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_EVENTS + "("
            + KEY_ID + " INTEGER," + KEY_TITLE + " TEXT,"
            + KEY_TIME + " TEXT," + KEY_DATE + " TEXT" + ")";
    db.execSQL(CREATE_EVENTS_TABLE);

}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // Drop older table if existed
    db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);

    // Create tables again
    onCreate(db);

}

/**
 * All CRUD(Create, Read, Update, Delete) Operations
 */


//adding an event (NEEDS TO ADD DRAWABLE)
 public void addEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, event.get_Id()); //Event ID
        values.put(KEY_TITLE, event.get_title()); // Event Title
        values.put(KEY_TIME, event.get_time()); // Event Time
        values.put(KEY_DATE, event.get_date()); // Event Date
        //values.put(KEY_DRW, event.get_drawable()); // Event Drawable

        // Inserting Row
        db.insert(TABLE_EVENTS, null, values);
        db.close(); // Closing database connection
    }

   // Getting single contact
   public Event getEvent(int id) {
       SQLiteDatabase db = this.getReadableDatabase();

       Cursor cursor = db.query(TABLE_EVENTS, new String[] { KEY_ID,
               KEY_TITLE, KEY_TIME, KEY_DATE }, KEY_ID + "=?",
               new String[] { String.valueOf(id) }, null, null, null, null);
       if (cursor != null)
           cursor.moveToFirst();

       Event event = new Event(Integer.parseInt(cursor.getString(0)),
               cursor.getString(1), cursor.getString(2), null, null);
       // return contact
       return event;
   }


    // Getting All Contacts
   public List<Event> getAllContacts() {
      List<Event> eventList = new ArrayList<Event>();
      // Select All Query
      String selectQuery = "SELECT  * FROM " + TABLE_EVENTS;

      SQLiteDatabase db = this.getWritableDatabase();
      Cursor cursor = db.rawQuery(selectQuery, null);

      // looping through all rows and adding to list
      if (cursor.moveToFirst()) {
          do {
              Event event = new Event();
              event.set_Id(Integer.parseInt(cursor.getString(0)));
              event.set_title(cursor.getString(1));
              event.set_time(cursor.getString(2));
              event.set_date(cursor.getString(3));
              // Adding contact to list
              eventList.add(event);
          } while (cursor.moveToNext());
      }

      // return contact list
      return eventList;
  }

// Getting event Count
    public int getEventsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_EVENTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

 // Updating single contact
    public int updateEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, event.get_title());
        values.put(KEY_TIME, event.get_time());
        values.put(KEY_DATE, event.get_date());

        // updating row
        return db.update(TABLE_EVENTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(event.get_Id()) });
    }

    // Deleting single contact
    public void deleteEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EVENTS, KEY_ID + " = ?",
                new String[] { String.valueOf(event.get_Id()) });
        db.close();
    }