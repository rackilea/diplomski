public int weightedRandom( Random random, int max, Map<Integer, Integer> weights ) {
    int totalWeight = max;
    for( int weight : weights.values() ) {
        totalWeight += weight - 1;
    }

    int choice = random.nextInt( totalWeight );
    int current = 0;
    for( int i = 0; i < max; i++ ) {
        current += weights.containsKey( i ) ? weights.get( i ) : 1;
        if( choice < current ) {
            return i;
        }
    }

    throw new IllegalStateException();
}