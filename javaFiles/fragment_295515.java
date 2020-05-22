private News startNewItemIfRequired(News currentNewsItem, List<News> newsArray) {
    if (currentNewsItem==null){
        currentNewsItem = new News();
        newsArray.add(currentNewsItem);
    }
    return currentNewsItem;
}