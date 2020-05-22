@Entity(tableName = "last_state")
public class LastStateTable {

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    long id;
    @ColumnInfo(name = "date")
    String date;
    @TypeConverters(ListConverter.class) // This is missing in your code
    @ColumnInfo(name = "icons") // This is missing in your code
    List<Icon> icon;
}

@Entity(tableName = "icon" )
public class Icon {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    int id;
    @ColumnInfo(name = "nr")
    int nr;
    @ColumnInfo(name = "type")
    int type;
    @ColumnInfo(name = "value")
    int value;
}