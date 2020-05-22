public static class Article {
    String name;
    String description;
    List<Translation> translations;

    public void filterTranslations(String language) {
        String languageCriteria = 
                translations.stream().anyMatch(t -> t.language.equals(language)) 
                ? language : "en";

        translations.removeIf(t -> !t.language.equals(languageCriteria));
    }
}