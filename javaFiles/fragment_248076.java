protected ArrayList<String> eraseStopWord (String[] tempWords) throws SQLException, ClassNotFoundException{
    result = new ArrayList<String>();
    db = new Query();
    for(int i=0;i<tempWords.length;i++){

         if(!db.isStopWords(tempWords[i])){
             result.add(tempWords[i]);
         }   
    }

    return result;

}