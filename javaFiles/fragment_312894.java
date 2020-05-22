Long foo = null;

    Optional<Long> optFoo = Optional.ofNullable( foo );
    if ( ! optFoo.empty() ) {
        long longFoo = optFoo.get();

        System.out.println( longFoo );
    }