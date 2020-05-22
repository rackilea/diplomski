public static void news(int size, int page) {
    // 'size' is the number of elements displayed per page
    // 'page' is the current page index, starting from 1.
    int start = page * size;
    List<News> allNews = News.find("order by date desc").from(start).fetch(size);
    // Once the list of news is found, we return them in Json format...
    renderJSON(allNews, new NewsJsonSerializer());
}