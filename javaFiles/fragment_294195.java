Map<Short, List<String>> fieldNamesById = 
        Arrays.stream(InterfaceWithIds.class.getDeclaredFields())

         //using short.class, not Short.class
        .filter(f -> f.getType().equals(short.class)) 

        //group by value, mapping fields to their names in a list
        .collect(Collectors.groupingBy(f -> getValue(f),
                Collectors.mapping(Field::getName, Collectors.toList())));