private static final Map<Integer,Boolean> map =
        ((Supplier<Map<Integer,Boolean>>)() -> {
            Map<Integer,Boolean> mutableMap = new HashMap<>();
            mutableMap.put( 1, false );
            mutableMap.put( 2, true );
            return Collections.unmodifiableMap( mutableMap );
        }).get();