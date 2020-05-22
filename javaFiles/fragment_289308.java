private boolean checkDatabase(){
    File dbFile = new File(DB_PATH + DB_NAME);
    if(dbFile.exists()){
       return true;
    }
    else{
       //This'll create the directories you wanna write to, so you
       //can put the DB in the right spot.
       dbFile.getParentFile().mkdirs();
       return false;
    }
}