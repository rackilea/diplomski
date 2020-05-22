public class RadioInfo {
    private Response response;
    // getters setters
}

public class Item {
    private Integer episodeId;
    private String type;
    private String title;
    //getter setters
}



public class Response {
    private List<Item> items = new ArrayList<Item>();
    private String nextUrl;
    //getters setters
}