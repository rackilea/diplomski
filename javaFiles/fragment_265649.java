// Read in the response
// Set up an initial input stream:
InputStream inputStream = fetchAddr.getInputStream(); // fetchAddr is the HttpURLConnection

// Check if inputStream is GZipped
if("gzip".equalsIgnoreCase(fetchAddr.getContentEncoding())){
    // Format is GZIP
    // Replace inputSteam with a GZIP wrapped stream
    inputStream = new GZIPInputStream(inputStream);
}else if("deflate".equalsIgnoreCase(fetchAddr.getContentEncoding())){
    inputStream = new InflaterInputStream(inputStream, new Inflater(true));
} // Else, we assume it to just be plain text

BufferedReader sr = new BufferedReader(new InputStreamReader(inputStream));
String inputLine;
StringBuilder response = new StringBuilder();
// ... and from here forward just read the response...