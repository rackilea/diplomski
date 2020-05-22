public static final String MAX_TRANSFER_SIZE = "4294967295";

...

HttpHeaders headers = new HttpHeaders();
Map<String, String> headerValues = new HashMap<String, String>();
if (resource.contentLength() > Long.parseLong(MAX_TRANSFER_SIZE))
{
        // This is as high as the content length can go. At this size,
        // RestTemplate automatically converts from using Content-Length to
        // using Transfer-Encoding:chunked.
        headerValues.put("Content-Length", MAX_TRANSFER_SIZE);
}
headers.setAll(headerValues);