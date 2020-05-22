Scanner scanner = new Scanner(System.in);

String filteringOption = scanner.nextLine();
String userInput = scanner.nextLine();

BiPredicate<String, Message> predicate = criteria.get(filteringOption);

// get all messages from the storage
getAll()  
        // make a stream out of them
        .stream()
        // apply the filtering rule from the map
        .filter(m -> predicate.test(userInput, m))  
         // collect them into a list to display
        .collect(Collectors.toList());