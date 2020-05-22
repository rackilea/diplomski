public class YourAppHeaders extends HttpHeaders {
    public YourAppHeaders()            
        add("Pragma", "no-cache");
        add("Expires", "Thu, 01 Jan 1970 00:00:00 GMT");
        add("Cache-Control", "max-age=0, no-cache, no-store");
    }
}