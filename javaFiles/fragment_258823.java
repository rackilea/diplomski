List<ResultSet> result = productList.stream()
                .collect(Collectors.groupingBy(ProductBean::getName))
                .entrySet()
                .stream()
                .map(e -> {
                    ResultSet resultSet = new ResultSet();
                    BigDecimal sum = e.getValue().stream()
                            .map(ProductBean::getAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    resultSet.setName(e.getKey());
                    resultSet.setAmount(sum);
                    resultSet.setProductBeans(e.getValue());
                    return resultSet;
                }).collect(Collectors.toList());