public List<Integer> findByString( String seq ) {
    List<Integer> indices = new ArrayList<Integer>();
    int strIdx = 0;

    while ( strIdx < gene.length() ) {
        int idx = gene.indexOf( seq, strIdx );
        if ( idx == -1 )
            break;
        indices.add( idx );
        strIdx = idx + seq.length();
    }

    return indices;
}