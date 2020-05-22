final Multimap<String, String> multimap = ArrayListMultimap.create();

    for ( String element : arrayList ) {
        String[] splitted = element.split( "=" );
        multimap.put( splitted[0], splitted[1] );
    }