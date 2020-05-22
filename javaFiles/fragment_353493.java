public List<Integer> findBySb( String seq ) {
    List<Integer> indices = new ArrayList<Integer>();
    StringBuilder sb = new StringBuilder( gene );
    int strIdx = 0;

    while ( strIdx < sb.length() ) {
        int idx = sb.indexOf( seq, strIdx );
        if ( idx == -1 )
            break;
        indices.add( idx );
        strIdx = idx + seq.length();
    }

    return indices;
}