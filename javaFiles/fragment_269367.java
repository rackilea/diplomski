public final class SQLiteContract{

// this shouldn't be instantiate
public SQLiteContract(){}

public static abstract class UserContract implements BaseColumns {

    /*                              TableName                           */

    public static final String TABLE_NAME = "USER";

    /*                              Fields                             */

    public static final String COLUMN_NAME_NAME = "Name";
    public static final String COLUMN_NAME_SURNAME = "Surname";
    public static final String COLUMN_NAME_TIME = "Time";
    public static final String COLUMN_NAME_DATE = "Date";
}