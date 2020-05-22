Map<LocalDateTime, Integer> voteSums = 
    map.entrySet()
       .stream()
       .collect(Collectors.toMap(Map.Entry::getKey,
                                 e -> e.getValue()
                                       .stream()
                                       .mapToInt(Vote::getVoteValue)
                                       .sum()));