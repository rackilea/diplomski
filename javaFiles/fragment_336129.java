List<Element> rssChildren = rss.getChildren();
// getElement(rssChildren);
for (int i = 0; i < rssChildren.size(); i++) {
    Element rssChild = rssChildren.get(i);
    System.out.println(rssChild.getName());// prints 'title' and 'link'
    List<Content> rssContents = rssChild.getContent();
    for (int j = 0; j < rssContents.size(); j++) {
        Content content = rssContents.get(j);
        System.out.println(content.getValue());
    }
}