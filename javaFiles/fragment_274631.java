public void createDataBase() throws IOException 
{ 
  //If database not exists copy it from the assets 

   boolean mDataBaseExist = checkDataBase(); 
   if(!mDataBaseExist) 
   { 
      try  
      { 
        //Copy the database from assests 
        copyDataBase(); 
        Log.e(TAG, "createDatabase database created"); 
      }  
      catch (IOException mIOException)  
      { 
         throw new Error("ErrorCopyingDataBase"); 
     } 
  } 
}