// you need to move your synchronized block out to here
    FailSafeValueOf<U> fsvo = (FailSafeValueOf<U>)CACHE.get(enumClass);
    if ( fsvo == null ) {
        synchronized (FailSafeValueOf.class) {
           ...
           CACHE.put(enumClass,fsvo);
        }
    }