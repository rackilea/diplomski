private static void listp(List<Food> f, double priceP, int limit) {
    f.stream()
            .filter(food -> food.getPrice() <= priceP)
            .sorted(Comparator.comparingDouble(Food::getPrice))
            .limit(limit)
            .forEach(food -> System.out.printf("%s : %s%n", food.getName(), food.getPrice()));
}