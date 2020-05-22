String[] searchwords = myMessageString.split(" ");
int processedWords = 0;
ArrayList<String> foundWords = ArrayList<String>();
for ( int i=0; i < searchwords.length; i++) {
   myAsyncTaskSearchDatabase(searchwords[i]){
        public override onPostExecute(foundWordOrNull){
             processedWords++;
             if(foundWordOrNull != null){
                 foundWords.add(foundWordOrNull);
             }

             if(processedWords = searchwords.length){
                 //handle all found words
             }
        }
   }.execute();
}