private String encryptSQLQuery(String plainSQLQuery){
    StringBuilder cipherQuery = new StringBuilder();
    String plainQuery = plainSQLQuery;
    String[] splitQuery = plainQuery.split("\\s+");
    for(String queryWord : splitQuery){
       if(!isSQLKeyWord(queryWord))
           queryWord = cryptoObject.encryptAndEncode(queryWord);
       cipherQuery.append(queryWord);
       cipherQuery.append(" ");
    }
    return cipherQuery.toString();
}