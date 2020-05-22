public someNonTransactionalTest() {
    //read and modify entity, get detached copy
    MyEntity detachedCopy1 = someRepository.readAndModify(1L); 

    //read and modify entity, get another detached copy - copy 1 is stale now
    MyEntity detachedCopy2 = someRepository.readAndModify(1L); 

    // try to merge the stale copy to a session, the optimistic locking exception is thrown
    detachedCopy1 = entityManager.merge(detachedCopy1);

    ... assertions ...
}