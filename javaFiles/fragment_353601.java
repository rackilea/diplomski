Map<Long , String> employeeNamesById = 
    list.stream()
        .collect(Collectors.toMap(array -> (Long) array[0],
                                  array -> (String) array[1],
                                  (name1, name2) -> name1));
System.out.println("employeeNamesById = " + employeeNamesById);
// prints employeeNamesById = {1=employee1, 2=employee2, 3=employee3}