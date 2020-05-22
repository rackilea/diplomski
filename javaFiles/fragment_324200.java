HTTPResponse response = URLFetchServiceFactory.getURLFetchService()
            .fetch(new URL("url_to_fetch"));
List<HTTPHeader> headers = response.getHeaders();

for (HTTPHeader h : headers) {
    if (h.getName().equals("Content-Type")) {
        /*
        * could be text/html; charset=iso-8859-1.
        */
        if (h.getValue().startsWith("text/html")) {
            /* TODO do sth. */
        }
    }
}