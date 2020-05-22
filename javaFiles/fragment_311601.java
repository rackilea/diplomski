public static void main(String[] args) {

    Map<X, List<Y>> results = new HashMap<>();
    List<X> allX = getAllX();

    //simple way to just replace old for loop with forEach
    allX.stream().forEach(x -> {
        List<Y> matchingY = getMatchingY(x.id);
        sortListY(matchingY);
        results.put(x, matchingY);
    });

    //a little bit fancier, assumes sortListY return List<Y>
    allX.stream()
            .map((X x) -> new AbstractMap.SimpleEntry<>(x, sortListY(getMatchingY(x.id))))
            .forEach(e -> results.put(e.getKey(), e.getValue()));

    //more fancy, assumes sortListY return List<Y>
    Map<X, List<Y>> results2 = allX.stream()
            .map((X x) -> new AbstractMap.SimpleEntry<>(x, sortListY(getMatchingY(x.id))))
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));

    //most fancy, assumes sortListY return List<Y>
    Map<X, List<Y>> results3 = allX.stream()
            .collect(Collectors.toMap(Function.identity(), x -> sortListY(getMatchingY(x.id))));


    //most fancy part 2, assumes sortListY return List<Y>
    Map<X, List<Y>> results4 = allX.stream()
            .collect(Collectors.toMap(x -> x, x -> sortListY(getMatchingY(x.id))));

}