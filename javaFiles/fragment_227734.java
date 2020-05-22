Collection<Pricing> result3 =
        allPricings.stream()
                .collect(groupingBy(Pricing::getUserCode,
                        collectingAndThen(
                                reducing((p1, p2)-> {
                                    p1.setPrice(p1.getPrice() + p2.getPrice());
                                    return p1;
                                }), Optional::get)))
                .values();