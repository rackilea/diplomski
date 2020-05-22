while (resultsApp.hasMoreElements()) {
    SearchResult result = (SearchResult) resultsApp.next();
    String DN = "";
    DN = result.getNameInNamespace();
    if (!DN.isEmpty()) {
        eDir_AllUsersDNList.add(i, DN);
        i++;
    }
    resultsApp.nextElement();
}