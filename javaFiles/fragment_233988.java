encodeField(String in)
{
    // usually, this would be
    //  return java.net.URLEncoder.encode(in, "UTF-8");
    // but this site *appears* to use a non-standard mapping
    return java.net.URLEncoder.encode(in.replace(' ', '_'), "UTF-8");
}

getLyricsText(String artist, String song)
{
    // construct the REST query URL
    String query = "http://lyrics.wikia.com/api.php?func=getSong&artist="
                 + encodeField(artist)
                 + "&song="
                 + encodeField(song)
                 + "&fmt=text";
    // open the URL and get a stream to read from
    java.net.URL url = new java.net.URL(query);
    java.io.InputStream is = url.openStream();
    // get the text from the stream as lines
    java.io.BufferedReader reader = new java.io.BufferedReader(is);
    StringBuilder buf = new StringBuilder();
    String s;
    while ( (s = reader.readLine()) != null )
        buf.append(s).append('\n');
    // return the lines
    return buf.toString();
}