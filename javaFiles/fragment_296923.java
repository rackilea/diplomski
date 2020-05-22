List<Pair<String, Double>> mostRelevantTitles = 
    implicitDataSum.entrySet()
                   .stream()
                   .sorted(Comparator.comparing(e -> -e.getValue()))
                   .map(e -> new Pair<>(e.getKey(), e.getValue()))
                   .collect(Collectors.toList());