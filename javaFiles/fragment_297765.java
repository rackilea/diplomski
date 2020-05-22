public News parseFive() {
    final News news = restTemplate
        .getForObject("https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=19acc3a371d145ecb37a093f9985ea21", Response.class);

    news.setArticles(news.articles.stream().limit(5).collect(Collectors.toList());

    return news;
}