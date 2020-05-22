private static List<Timestamp> removeDuplicates(List<Timestamp> list) {
        Map<String, Timestamp> collect = list
                .stream()
                .collect(Collectors.toMap(Timestamp::getId,
                        v -> v,
                        (u, v) -> u.getTimestamp().compareTo(v.getTimestamp()) > 0 ? u : v));
       return new ArrayList<>(collect.values());
    }