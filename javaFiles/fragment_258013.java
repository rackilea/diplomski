Map<Integer, Long> result = bookings.stream()
        .collect(Collectors.collectingAndThen(
                Collectors.groupingBy(Booking::getCampoID, Collectors.counting()),
                map -> {
                    map2.keySet().forEach(k -> map.putIfAbsent(k, 0L));
                    return map;
                }));