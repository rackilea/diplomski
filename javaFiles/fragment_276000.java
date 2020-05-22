public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CustomDaoMaster.OpenHelper helper = new CustomDaoMaster.OpenHelper(this, "Images-bd", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        CustomDaoMaster daoMaster = new CustomDaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
    }
}