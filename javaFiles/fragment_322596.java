List<String> userNames = new LinkedList<>();
userDatabase.stream()
    .sorted( Users.USER_NAME.comparator() )
    .limit( 10 )
    .forEach( p ->  {
        users.add( p.getUsername() );
    } );
return users;