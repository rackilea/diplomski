List<DiffOrders> matchedOrders = current.stream()
    .flatMap(curr -> {
      Optional<Order> p = previous.stream()
          .filter(prev -> OrderPredicate.orderSameDirectionAndSize(curr, prev))
          .findFirst();
      if (p.isPresent() && !p.get().qty.equals(curr.qty)) {
        return Stream.of(new DiffOrders(curr.user, curr.tradeDate, curr.qty, p.get().qty));
      } else {
        return Stream.empty();
      }
    }) 
    .collect(Collectors.toList());