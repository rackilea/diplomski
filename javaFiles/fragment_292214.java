String[] searchwords = myMessageString.split(" ");
    bool wasFound = false;
    for ( int i=0; i < searchwords.length; i++) {
       new myAsyncTaskSearchDatabase(searchwords[i]){
            public override onPostExecute(foundWordOrNull){
                 processedWords++;
                 if(foundWordOrNull != null){
                     wasFound = true;
                 }

                 if(processedWords = searchwords.length){
                      if(wasFound){
                           //do something
                      }else{
                           //no matches
                      }
                 }
            }
       }.execute();
    }