SearchResult result = null;
for (String attempt : "10,20,30".split(","))
    if ((result = doSearch(attempt)) != null)
        break;

if (result == null) {
    // put code to deal with lack of results here
}