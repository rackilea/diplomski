public static synchronized ArticleRepository getInstance(Application application){
    if(INSTANCE == null){
        Log.d(TAG, "ArticleRepository getInstance is NULL");
        INSTANCE = new ArticleRepository(application);
    }

    return INSTANCE;
}