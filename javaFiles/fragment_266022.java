Observable<List<Account>> accountsList = getFriendUserIds()
.take(1)
.flatMapIterable(list -> list)
.flatMap(id -> getAccount(id))
.toList()
.toObservable();