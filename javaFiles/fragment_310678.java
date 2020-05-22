private static final String SEARCH_PAGE = "some search page link here";

public class Region {
    private final int perSession;
    private final String link;

    public Region(int perSession, String link) {
        this.perSession = perSession;
        this.link = link;
    }

    // getters here
}

List<Region> regions = new ArrayList<Region>();
regions.add(new Region(500, "somehref.com/page="));

for(Region region : regions) {
    for(int i = 0; i < region.getPerSession(); i++) {
        submit(new SiteRequest(region.getLink() + i, SEARCH_PAGE));
    }
}