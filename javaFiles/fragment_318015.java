NavigableSet<Integer> ns = new TreeSet<Integer>( Arrays.asList( 1, 2, 3 ) );
        Iterator<Integer> iterator = ns.iterator();

        while( iterator.hasNext() ){
            Integer next = iterator.next();
            if( next < 2 ){
                iterator.remove();
            }
        }

        System.out.println( ns );