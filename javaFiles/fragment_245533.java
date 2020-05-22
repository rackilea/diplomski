Set<IdType> id = selection.getItems().stream()
    .map(element -> element.getId())
    .collect(Collectors.toSet());

…

.filter(ele -> id.contains(ele.getId())