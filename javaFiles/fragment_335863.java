@Entity(tableName = "cards",foreignKeys = {
        @ForeignKey(entity = Folders.class, parentColumns = "folder_id", childColumns = "current_folder_id", onDelete = CASCADE)})
public class Cards {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "card_id")
    private int cardId = 0;

    @ColumnInfo(name = "card_name")
    private String cardName;

    @ColumnInfo(name = "card_value")
    private String cardValue;

    @ColumnInfo(name = "current_folder_id")
    private int folderId;

    @Ignore
    public Cards() {
    }
}