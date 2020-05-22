Collection<OrderTotal> result = orders.stream()
            .map(o -> createFromOrder(o))
            .collect(toMap(Function.identity(),
                        Function.identity(),
                        (l, r) -> {
                            aggregate(l, r);
                            return l;
                        }))
                .values();