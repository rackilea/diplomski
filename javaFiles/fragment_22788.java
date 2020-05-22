Stream.of(scores)
        .collect(
                Collectors.groupingBy(a -> a[0], 
                Collectors.averagingInt(a -> Integer.parseInt(a[1]))))
        .entrySet()
        .stream()
        .max(Entry.comparingByValue())
        .ifPresent(bestScore -> {
                String message = String.format("Best score is %s, by %s", bestScore.getValue(), bestScore.getKey());
                System.out.println(message);
        });