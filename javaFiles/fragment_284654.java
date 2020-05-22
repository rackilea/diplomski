// Repository
suspend fun insert(title: Title)
{
    withContext(Dispatchers.IO)
    {
        dao.insertTitle(title)
    }
}