public StringBuffer createHeader(int contentLength) {
    StringBuffer header = new StringBuffer(100);
    header.append("--yourboundary\r\nContent-Type: image/jpeg\r\nContent-Length: ");
    header.append(contentLength);
    header.append("\r\n\r\n");

    return header;
}