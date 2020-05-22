Map<A, Collection<B>> resultMap = listofA.stream()
       .collect(Collectors.toMap(Function.identity(), repo::getListofB, 
            (a, b) -> {
                a.addAll(b);
                return a;
        }));