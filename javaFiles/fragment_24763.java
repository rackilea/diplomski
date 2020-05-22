List<CodeSample> result = 
    segments.stream()
            .collect(Collectors.groupingBy(Segment::getSet))
            .entrySet()
            .stream()
            .map(entry -> new CodeSample(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());