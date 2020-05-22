Map<String, List<Product>> res = operations.parallelStream().filter(s -> s.getTotal() > 10)
    .collect(groupingBy(Selling::getClientName, mapping(Selling::getProducts,
        Collector.of(ArrayList::new, List::addAll, (x, y) -> {
            x.addAll(y);
            return x;
        }))));