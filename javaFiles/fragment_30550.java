public static <T> Map<Boolean,List<T>> splitData(
    List<CommonItem> listOfCommonItems, BiFunction<String,Boolean,T> mapper) {

    return listOfCommonItems.stream()
        .collect(Collectors.partitioningBy(CommonItem::isSelected,
            Collectors.mapping(ci -> mapper.apply(ci.getName(), ci.isSelected()),
                Collectors.toList())));
}