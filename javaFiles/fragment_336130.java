for (Element rssChild : rss.getChildren()) {
    System.out.println(rssChild.getName());// prints 'title' and 'link'
    for (Element subRss : rssChild.getChildren()) {
        System.out.println(subRss.getValue());
    }
}