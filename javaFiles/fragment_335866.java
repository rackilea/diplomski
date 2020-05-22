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

    public Cards() {}

    @Ignore
    public Cards(String cardName, String cardValue, int folderId) {
        this.cardName = cardName;
        this.cardValue = cardValue;
        this.folderId = folderId;
    }

    public Folders getOwningFolders(GamesDatabase gdb) {
        return gdb.getGamesDBDao().getAFoldersRowById(folderId);
    }

    public Categories getOwningCategories(GamesDatabase gdb) {
        return gdb.getGamesDBDao().getACategoriesRowById(getOwningFolders(gdb).getCategoryId());
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }
}