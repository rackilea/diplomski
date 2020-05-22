ImmutableListMultimap<String, Employee> byName = 
  Multimaps.index(employees, new Function<Employee, String>(){
      @Override
      public String apply(Employee e) {
          return e.getName();
      } 
  });