TestObserver repositoryInsertObserver = TestObserver.create();
Completable insertCompletable = Completable.complete()
    .doOnSubscribe(d -> repositoryInsertObserver.onSubscribe(d));

//pass completable to your mock
given(repository.insert(data)).willReturn(insertCompletable);

//and verify that subscription took place
repositoryInsertObserver.assertSubscribed();