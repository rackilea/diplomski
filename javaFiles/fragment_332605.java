List<MyJoinObject> result = 
    list1.stream().map( o1 -> {
        Optional<MyObject2> error = list2.steam()
                                         .filter( o2 -> o2.getId() == o1.getId() )
                                         .findAny();
        if ( error.isPresent() ) 
            return new MyJoinObject( o1.getId(), o1.getName(), error.get().getError() );      

        return new MyJoinObject( o1.getId(), o1.getName() );

    } ).collect( Collectors.toList() );