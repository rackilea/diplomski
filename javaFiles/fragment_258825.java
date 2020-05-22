List<ResultSet> result = productList.stream()
                .collect(Collectors.groupingBy(ProductBean::getName))
                .entrySet()
                .stream()
                .map(Main::mapToResultSet) // Main representing the class containing the mapToResultSet method
                .collect(Collectors.toList());