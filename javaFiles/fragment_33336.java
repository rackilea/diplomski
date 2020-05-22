void doSomething( ItemBase itemBase, DueToBase dueToBase ) {
    Integer itemBaseIndex = itemBaseMap.get( itemBase.getClass() );
    Integer dueToBaseIndex = dueToBaseMap.get( dueToBase.getClass() );

    Algorithm algorithm = algorithmTable[ itemBaseIndex, dueToBaseIndex ];

    algorithm.executeAlgorithm();
}