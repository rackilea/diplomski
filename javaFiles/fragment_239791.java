user.getAcquisitions()
    .parallelStream()
    .flatMap(e -> e.getPurchase().stream())
    .distinct()
    .sorted(Comparator.comparing(Purchase::getPurchaseDate).reversed())
    .collect(toCollection(ArrayList::new));