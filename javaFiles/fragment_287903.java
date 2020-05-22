Collection<Integer> acctIDstoValidate = ...;
Collection<Account> accountDetailsinRedis = ...;


List<Account> matching = acctIDstoValidate.stream()
         .flatMap(idToValidate-> accountDetailsinRedis.stream()              
                           .filter(b-> b.getId() == idToValidate))
         .collect(Collectors.toList());