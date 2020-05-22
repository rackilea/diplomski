Set<IdType> id = selection.getItems().stream().map(element -> element.getId());

List<ElementType> list = DATA.accounts.stream()
    .flatMap(estimate -> estimate.getElements().stream())
    .filter(ele -> id.contains(ele.getId())
    .collect(Collectors.toList());

IntStream.range(0, list.size())
    .forEach(ix -> {
        ElementType element = list.get(ix);
        element.setDateSchedualed(selectedDate);
        element.setOrder(ix+1);
    });