Map<Integer, Map<String, Integer>> result = shopping.entrySet()
            .stream()
            .collect(groupingBy(e -> e.getKey().getAge(),
                        flatMapping(e -> e.getValue().keySet().stream(),
                            groupingBy(Product::getCategory,
                                    summingInt(e -> 1)))));