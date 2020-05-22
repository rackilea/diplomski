List<Subscription> foo = list.stream()
          .map(s -> s.services.entrySet().stream()
                        .filter(x -> x.getValue() != null)
                        .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue)))
          .map(m -> new Subscription(m))
          .collect(Collectors.toList());