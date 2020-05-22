List<Pricing> allPricings = getAllPricings();

List<Pricing> result = allPricings.stream()
        .collect(Collectors.groupingBy(Pricing::getUserCode))
        .entrySet().stream()
        .map(e -> e.getValue().stream()
                .reduce((f1,f2) -> new Pricing(f1.getId(),f1.getPrice() + f2.getPrice(),f1.getUserCode())))
        .map(f -> f.get())
        .collect(Collectors.toList());