public class BingSearchResults {

public ResultsContent d;

public static class ResultsContent {
    public Result[] results;
    public String __next;
}

public static class Result {
    public String ID;
    public String Title;
    public String Description;
    public String DisplayUrl;
    public String Url;
    public Metadata __metadata;

}

public static class Metadata {
    public String uri;
    public String type;
}

}