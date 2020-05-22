Set<String> streets = addressList.stream()
    .map(address -> address.street)
    .collect(Collectors.toSet());
Collection<Hotel> filtered = hotels.stream()
    .filter(hotel -> streets.contains(hotel.address))
    .collect(Collectors.toList());