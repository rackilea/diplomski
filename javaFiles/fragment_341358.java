URI uri = new URI(
    "http", 
    "search.barnesandnoble.com", 
    "/booksearch/é",
    null);
String request = uri.toASCIIString();