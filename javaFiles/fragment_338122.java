Document document = Jsoup.parse(html);
document.getAllElements().stream()
        .filter(e -> e.ownText().isEmpty())
        .filter(Element::hasParent)
        .forEach(e -> {
            e.children().forEach(e.parent()::appendChild);
            e.remove();
        });