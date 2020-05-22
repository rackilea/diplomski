private List<Whiskey> getWhiskeyFromCountry(String origin) {

    return bottles.stream()
            .filter(b -> b.getOrigin().equals(origin))
            .collect(Collectors.toList());
  }