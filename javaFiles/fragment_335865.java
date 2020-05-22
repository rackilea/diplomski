@Entity(tableName = "folders", foreignKeys = @ForeignKey(entity = Categories.class,
        parentColumns = "category_id", childColumns = "current_category_id", onDelete = ForeignKey.CASCADE))
public class Folders {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "folder_id")
    private int folderId = 0;

    @ColumnInfo(name = "folder_name")
    private String folderName;

    @ColumnInfo(name = "current_category_id")
    private int categoryId;

    public Folders() {}

    @Ignore
    public Folders(int categoryId, String folderName) {
        this.categoryId = categoryId;
        this.folderName = folderName;
    }

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Categories getOwningCategories(GamesDatabase gdb) {
        return gdb.getGamesDBDao().getACategoriesRowById(this.categoryId);
    }
}