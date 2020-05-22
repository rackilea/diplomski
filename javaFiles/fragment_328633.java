entityManagerFactory
            .getProperties()
            .entrySet()
            .stream()
            .filter( entry -> entry.getKey().startsWith( "hibernate." ) )
            .forEach( entry -> log.debug( entry.toString() ) );