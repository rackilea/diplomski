public class MyConverterForRSS20 extends ConverterForRSS20 {

    public MyConverterForRSS20() {
        this("rss_2.0");
    }

    protected MyConverterForRSS20(String type) {
        super(type);
    }

    @Override
    protected SyndEntry createSyndEntry(Item item, boolean preserveWireItem) {
        SyndEntry syndEntry = super.createSyndEntry(item, preserveWireItem);
        Source source = item.getSource();
        if (source != null) {
            SyndFeed syndFeed = new SyndFeedImpl();
            syndFeed.setLink(source.getUrl());
            syndFeed.setAuthor(source.getValue());
            syndEntry.setSource(syndFeed);
        }
        return syndEntry;
    }
}