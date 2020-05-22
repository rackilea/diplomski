Map<LocalDateTime, List<Invoice>> grouping =
        invoiceListForMonth.stream()
                .collect(Collectors.groupingBy(Invoice::getPurchaseDate));

Map<LocalDate, BigDecimal> result = grouping.entrySet().stream()
        .collect(Collectors.toMap(Map.Entry::getKey,
                e -> e.getValue().stream().map(Invoice::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
        );