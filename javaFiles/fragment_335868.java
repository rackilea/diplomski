@Database(version = 1,exportSchema = true, entities = {Categories.class,Folders.class,Cards.class})
public abstract class GamesDatabase extends RoomDatabase {

    public static final String DBNAME = "games";

    public abstract GamesDao getGamesDBDao();
}