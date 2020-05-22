List<Offer> some = offers.stream()
                         .filter(x -> x.getType() != OfferType.STANDARD)
                         .collect(Collectors.toCollection(ArrayList::new));

offers.stream()
      .filter(x -> x.getType() == OfferType.STANDARD)
      .min(Comparator.comparing(Offer::getPrice))
      .ifPresent(some::add);