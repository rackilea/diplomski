shopping.entrySet().stream()
    .collect(
        Collectors.groupingBy(Map.Entry::getKey,
            Collectors.flatMapping(
                e -> e.getValue().entrySet().stream()
                    .map(innerEntry -> innerEntry.getKey().getPrice()
                    .multiply(BigDecimal.valueOf(innerEntry.getValue()))),
            Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
    .entrySet().stream()
    .max(Map.Entry.comparingByValue()).get().getKey();