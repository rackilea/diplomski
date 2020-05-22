public void addObservation(String obs) {
    if( hm.contains(obs) )
        hm.put( obs, hm.get(obs)+1 );
    else
        hm.put( obs, 1 );
}