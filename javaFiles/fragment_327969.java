public List<Model> getFilteredList(List<Model> originalList, String x, String y, String z) {

    final BiPredicate<String, Supplier<String>> stringFilter = (filter, stringSupplier) ->
            filter.equals("any") || filter.equals(stringSupplier.get());

    return originalList.stream()
            .filter(model -> stringFilter.test(x, model::getX))
            .filter(model -> stringFilter.test(y, model::getY))
            .filter(model -> stringFilter.test(z, model::getZ))
            .collect(Collectors.toList());
}