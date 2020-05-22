List<SuccessfulAttempts> success = new ArrayList<>();
List<TotalAttempts> total = new ArrayList<>();

success.add(new SuccessfulAttempts("Alice", 4));
success.add(new SuccessfulAttempts("Bob", 7));

total.add(new TotalAttempts("Alice", 5));
total.add(new TotalAttempts("Bob", 10));

// First create a Map
Map<String, Integer> attemptsMap = success.parallelStream()
    .collect(Collectors.toMap(SuccessfulAttempts::getName, SuccessfulAttempts::getSuccessCount));

// Loop through the list of players and calculate percentage.
List<PercentageSuccess> percentage =
    total.parallelStream()
         // Remove players who have not participated from List 'total'. ('attempt' refers to single element in List 'total').
         .filter(attempt -> attemptsMap.containsKey(attempt.getName()))
         // Calculate percentage and create the required object
         .map(attempt -> new PercentageSuccess(attempt.getName(),
                    ((attemptsMap.get(attempt.getName()) * 100) / attempt.getTotalCount())))
         // Collect it back to list
         .collect(Collectors.toList());

percentage.forEach(System.out::println);