Map<String, Map<Integer, BigDecimal>> mapCountries = filteredList.stream()
        .collect(Collectors.groupingBy(MyObject::getCountry,
        Collectors.toMap( 
                s -> s.getYear(),
                s -> s.getValue()))
        );