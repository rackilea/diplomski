boolean dataExists = checkDB();
if( !dataExists ) {
  synchronized( someSharedObject ) {
    //another thread might have been waiting too and now has put the data into the DB
    //thus check again
    if( !checkDB() ) {
      calculateDataAndWriteToDB();
    }  
  }
}
//do whatever you want with the existing data