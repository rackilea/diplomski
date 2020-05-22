try {
    urlConnection.connect(); // open the connection
    urlConnection.getContent(); // send prepared request
} catch (IOException e) {
    e.printStackTrace();
}