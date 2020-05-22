return scores.stream()
        .mapToDouble(MatchScore::getScore)
        .sorted()
        .skip(1)
        .limit(scores.size() - 2)
        .average().getAsDouble();