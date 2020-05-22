serviceCallA()
.flatMap(a -> {
    if (dataFound(a)) {
        return dbCall1()
           .flatMap(db1 -> {
               Observable o1 = shouldCallServiceC(db1) 
                    ? serviceCallC() : just(placeholderC);
               Observable o2 = shouldCallDB2(db1) 
                    ? dbCall2() ? just(placeHolderDb2);

               return zip(o1, o2, (c, d) -> createResult(c, d));   
           });
    }
    return serviceCallB()
        .map(c -> mapToResultType(c));
});