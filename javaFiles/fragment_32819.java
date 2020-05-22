List<String> tokens = new ArrayList<String>();
    int next = 0;
    while (inFile1.hasNext()) {
        String line = inFile1.nextLine();
        if( next >= tokens.size() ){
            tokens.add( line );
        } else {
            tokens.set( next, tokens.get(next) + line );
        }                 
        if( line.endsWith( "$$" ) ) next++;
    }