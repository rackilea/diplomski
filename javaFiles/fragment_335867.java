@Dao
public interface GamesDao {

    @Insert()
    long[] insertCategoriesRows(Categories... categories);

    @Insert()
    long insertCategoriesRow(Categories categories);

    @Insert()
    long[] insertFoldersRows(Folders... folders);

    @Insert()
    long insertFoldersRow(Folders folders);

    @Insert
    long[] insertCardsRows(Cards... cards);

    @Insert()
    long insertCardsRow(Cards cards);

    @Delete()
    int deleteManyCategoriesRows(Categories... categories);

    @Delete()
    int deleteACategoriesRow(Categories categories);

    @Delete()
    int deleteManyFoldersRows(Folders... folders);

    @Delete()
    int deleteAFolders(Folders folders);

    @Delete()
    int deleteManyCardsRows(Cards... cards);

    @Delete()
    int deleteACardRow(Cards cards);

    @Query("SELECT * FROM categories")
    Categories[] getAllCategoriesRows();

    @Query("SELECT * FROM folders")
    Folders[] getAllFoldersRows();

    @Query("SELECT * FROM cards")
    Cards[] getAllCards();

    @Query("SELECT * FROM categories WHERE category_id = :id")
    Categories getACategoriesRowById(int id);

    @Query("SELECT * FROM folders WHERE folder_id = :id")
    Folders getAFoldersRowById(int id);

    @Query("SELECT * FROM cards WHERE card_id = :id")
    Cards getACardsRowById(int id);

    @Query("SELECT * FROM folders WHERE current_category_id = :id")
    Folders[] getFoldersPerCategoriesId(int id);
}