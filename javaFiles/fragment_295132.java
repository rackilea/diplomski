Map<String, String> phoneBook = 
    people.stream()
          .collect(Collectors.toMap(
             Person::getName,
             Person::getAddress,
             (address1, address2) -> {
                 System.out.println("duplicate key found!");
                 return address1;
             }
          ));