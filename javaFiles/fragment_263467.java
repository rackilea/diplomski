data class SomeClass(val a: String, val b: Int)

val list = listOf(SomeClass("1", 1), SomeClass("2", 2))

Observable
        .fromIterable(list)
        .zipWith(Observable.interval(2, TimeUnit.SECONDS),
                BiFunction { item: SomeClass, _: Long -> item })
        .subscribe { Log.v("someClass", it.toString())