List<Invoice> invoiceListForMonth = new ArrayList<>();
//add some data
Map<LocalDate, BigDecimal> result =
        invoiceListForMonth.stream()
                .collect(Collectors.groupingBy(
                        Invoice::getPurchaseDate
                )).entrySet().stream()//This will return a map of Map<LocalDateTime, List<Invoice>>
                .collect(Collectors.toMap(Map.Entry::getKey, // to collect with the date
                        e -> e.getValue().stream().map(Invoice::getPrice) //and the sum of
                                .reduce(BigDecimal.ZERO, BigDecimal::add)) // prices
                );