Map<Date, List<Invoice>> grouping =
        invoiceListForMonth.stream()
                .collect(Collectors.groupingBy(
                        p -> getDateWithoutTime(p.getPurchaseDate())
                ));
Map<Date, BigDecimal> result = grouping.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
                e -> e.getValue().stream().map(Invoice::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
        );