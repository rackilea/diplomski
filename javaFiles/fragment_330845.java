foodRepository.findAll().stream()
     .map(Food::getFoodToFoodGroup)
     .flatMap(Collection::stream)
     .collect(Collectors.groupingBy(
         f -> f.getFoodGroup().getName(),
         HashMap::new,
         Collectors.mapping(FoodToFoodGroup::getFood, Collectors.toList())));