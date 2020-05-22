public class DocumentedException extends Exception
{
    private String title;
    private String genericMessage;
    private String detailedMessage;
    private String url;

    // Generally avoid this long constructor, and define subclasses that only need detailedMessage
    public DocumentedException(String t, String g, String d, String u) {
        super(g + " - " + d); // sets the getMessage() return value to something sane
        title = t;
        genericMessage = g;
        detailedMessage = d;
        url = u;
    }

    public String toString() {
        return title.toUpperCase()+"\n"+
            genericMessage+"\n"+
            detailedMessage+"\n"+
            "More info on this error: "+url+"\n";
    }

    public static class BadData extends DocumentedException {
        public BadData(String details) {
            super("Bad Data", "Supplied data is not valid", details, "http://www.example.com/moreinfo/baddata");
        }
    }

    public static class MissingData extends DocumentedException {
        public MissingData(String details) {
            super("Missing Data", "Required data not found", details, "http://www.example.com/moreinfo/missingdata");
        }
    }
}