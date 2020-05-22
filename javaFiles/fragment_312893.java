Long foo = null;

Optional<Long> optFoo = Optional.ofNullable( foo );
long longFoo = optFoo.orElse( -1L );

System.out.println( longFoo );