StringBuilder s = 
    p.stream()
     .filter( p -> p.lastName.equals("kent"))
     .map(p -> p.lastName)
     .collect(StringBuilder::new,
              StringBuilder::append,
              StringBuilder::append);