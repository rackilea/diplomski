Map<String, List<Long>> map = 
personList.stream()
          .collect(groupingBy(
                         Person::getDepartment,
                         mapping(Person::getTimestamp, toList())
                        )
                  );