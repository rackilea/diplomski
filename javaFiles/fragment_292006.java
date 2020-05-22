private static final String CREATETABLE_PHOTO = "create table eqpphoto("EImage BLOB " + ");";

public static final String TABLE_PHOTO = "eqpphoto";

public long insertPhoto(byte[] EImage) {

        try {
            System.out.println("Function call : ");
            ContentValues values = new ContentValues();

            values.put(EIMAGE, EImage);
            return db.insert(TABLE_PHOTO, null, values);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }