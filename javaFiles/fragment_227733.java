Collection<Pricing> result2 = 
        allPricings.stream()
                .collect(groupingBy(Pricing::getUserCode, 
                        collectingAndThen(
                                reducing((p1, p2)-> new Pricing(p1.getId(),p1.getPrice() + p2.getPrice(),p2.getUserCode())), Optional::get)))
                .values();