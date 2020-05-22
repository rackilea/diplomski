writeRead.getArrayList(this).stream()
            .map(Game::getWinnerGamer)
            .collect(Collectors.groupingBy(Gamer::getName, Collectors.summingInt(Gamer::getLeaderboardScore)))
            .entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed())
            .map(entry -> new Gamer(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());