private static Map<Dish.Type, Set<String>> groupDishTagsByType(Map<String, List<String>> dishTags) {
    return Dish.menu.stream()
            .collect(Collectors.groupingBy(Dish::getType,
                     Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                            Collectors.toSet())));
}