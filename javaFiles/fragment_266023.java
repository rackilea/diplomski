Observable<List<Account>> accountsList = getFriendUserIds()
.flatMapSingle(list -> 
     Observable.fromIterable(list)
     .flatMap(id -> getAccount(id))
     .toList()
);