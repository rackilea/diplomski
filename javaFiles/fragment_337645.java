printWriter.println(
    this.getStatusLineFromStatusCode(statusCode) + CRLF
    + "Date: " + currentTime + CRLF
    + "Server: Definitely not Apache" + CRLF
    + ( (statusCode == 200) ?
            "Last-Modified: " + lastModified + CRLF : "" )
    + "Content-Length: " + dir.length() + CRLF
    + "Content-Type: " + fileType + CRLF + CRLF
);