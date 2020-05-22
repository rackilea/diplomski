List<User> list = ...
Map<Class<? extends User>, List<User>> groupedResult = list.stream()
        .collect(Collectors.groupingBy(e -> e.getClass()));
groupedResult
        .entrySet()
        .forEach(entry -> {
 //print the header for the object of the current class type
             entry.getValue()
                  .stream()
                  .findFirst()
                  .ifPresent(user -> user.getFormattedHeader());

           //print the data
            entry.getValue()
                 .forEach(user -> user.getFormattedInfo(user));
        });