Observable.fromIterable(list.filter { it != null })
.concatMap {
    if (it!! % 2 == 0) {
        return@concatMap Observable.error(IllegalArgumentException("Mod is true"))
                         .delay(3, TimeUnit.SECONDS, true)
    }
    Observable.just(it)
}
.take(1)