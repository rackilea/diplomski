public class Diary {
    public static final String TABLENAME = "diary";
    public static final String COLUMN_ID = BaseColumns._ID;
    public static final String COLUMN_DIARYNAME = "diaryName";

    private static final String crt_sql = "CREATE TABLE IF NOT EXISTS " + TABLENAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL, " +
            COLUMN_DIARYNAME + " TEXT UNIQUE" +
            ")";

    private long id;
    private String diaryName;

    public Diary(String diaryName) {
        this.diaryName = diaryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDiaryName() {
        return diaryName;
    }

    public void setDiaryName(String diaryName) {
        this.diaryName = diaryName;
    }

    public static String getCrt_sql() {
        return crt_sql;
    }
}