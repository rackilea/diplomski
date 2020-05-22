Flowable.timer(60, SECONDS)
  .flatMap( tick -> 
      Observable.fromIterable( mUserRepository.getAllUsers() ), 1 )
  .map( t -> Either.createLeft(t) )
  .mergeWith( taskInserter.map( i -> Either.createRight( i ) ), 1 )
  .observeOn( scheduler )
  .subscribe( ti -> {
    if ( ti.isLeft() ) {
      downloadAndPersistTasks( ti.getLeft() );
    } else {
      insertTask( ti.getRight() );
    }
   );