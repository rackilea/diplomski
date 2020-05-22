HeadMethod head = new HeadMethod("http://jakarta.apache.org");
// execute the method and handle any error responses.
...
// Retrieve all the headers.
Header[] headers = head.getResponseHeaders();

// Retrieve just the last modified header value.
String lastModified = head.getResponseHeader("last-modified").getValue();