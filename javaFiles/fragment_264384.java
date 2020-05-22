class DatabaseHelper {    //Public class

companion object {   ///This is equiavalent to java static.

    private var instance: YourDatabase? = null


    fun getDbInstance(context: Context): YourDatabase?  //This functions returns the initialized DB instance.
    {
        if(instance == null)
            instance = YourDatabase(context)   // initializing the DB only one time

        return instance
    }

   }
}