Set<String> retainTagNames = new HashSet<>(Arrays.asList("html", "body"));
Document document = Jsoup.parse(html);
document.getAllElements().stream()
        .filter(e -> ! retainTagNames.contains(e.tagName()))
        .filter(e -> e.ownText().isEmpty())
        .filter(Element::hasParent)
        .forEach(e -> {
            e.children().forEach(e.parent()::appendChild);
            e.remove();
        });