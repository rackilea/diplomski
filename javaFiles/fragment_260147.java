public class GZipRequest extends StringRequest {

    public GZipRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    public GZipRequest(String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
    }

    // parse the gzip response using a GZIPInputStream
    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String output = ""; // note: better to use StringBuilder

        try {
            final GZIPInputStream gStream = new GZIPInputStream(new ByteArrayInputStream(response.data));
            final InputStreamReader reader = new InputStreamReader(gStream);
            final BufferedReader in = new BufferedReader(reader);
            String read;
            while ((read = in.readLine()) != null) {
                output += read;
            }
            reader.close();
            in.close();
            gStream.close();
        } catch (IOException e) {
            return Response.error(new ParseError());
        }
        return Response.success(output, HttpHeaderParser.parseCacheHeaders(response));
    }
}