Collection<OrderTotal> result = orders.stream()
            .map(o -> createFromOrder(o))
            .collect(toMap(Function.identity(),
                    Function.identity(),
                    (l, r) -> {
                        l.setTotalQty(l.getTotalQty() + r.getTotalQty());
                        l.setTotalValue(l.getTotalValue() + r.getTotalValue());
                        return l;
                    }))
            .values();