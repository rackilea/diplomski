@Database(entities = arrayOf(DataBaseUser::class), version = 1)
abstract class DataBase : RoomDatabase() {
    abstract fun getUserDao(): DataBaseUserDao
}

object DatabaseProvider {
    val DB_NAME : String = "DataBaseUser"
    private lateinit var INSTANCE : DataBase

    fun getDataBase(context: Context): DataBase {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,DataBase::class.java,DB_NAME).build()
        }

        return INSTANCE
    }
}