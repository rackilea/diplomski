writeRead.getArrayList(this).stream()
            .map(Game::getWinnerGamer)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(Gamer::getLeaderboardScore)))
            .entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry<Gamer, Integer>::getValue).reversed())
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());