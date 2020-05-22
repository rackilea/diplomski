for (final Iterator iter = feed.getEntries().iterator();
     iter.hasNext(); )
{
    final SyndEntry entry = (SyndEntry) iter.next();
    String title = entry.getTitle();
    String uri = entry.getUri();
    //...
}