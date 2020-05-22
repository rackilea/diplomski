...
if (delayTimer == 0) {
    ArrayList< Integer > availableIndexes = new ArrayList< Integer >();
    for ( int i = 0; i < 3; ++i ) {
        if ( i != xIndexEnemyOld ) {
            availableIndexes.add( i );
        }
    }
    int selectedIndex = new Random().nextInt( availableIndexes.size() );
    xIndexEnemy = availableIndexes.get( selectedIndex );
}
// Else no need to use the array
else {
    xIndexEnemy = new Random().nextInt( 3 );
}
...