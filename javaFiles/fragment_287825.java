public void log()  {
   //Common logging stuff here
}
public void logDB()  {
   //Database-specific logging here...
   log();
}
public void logMongo()  {
   //Mongo-specific logging here...
   log();
}