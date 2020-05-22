void filterArticleTranslations(List<Article> articles, String language) {
    articles.forEach(article -> {
        String languageCriteria = 
                article.translations.stream().anyMatch(t -> t.language.equals(language)) 
                ? language : "en";

        article.translations.removeIf(t -> !t.language.equals(languageCriteria));
    });
}