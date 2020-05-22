class A(val filterable: Boolean = random.nextBoolean())

class B(val name: String = random.nextInt().toString(), val listOfA: List<A> = listOf(A(), A(), A(), A(), A(), A()))

@Test
fun rxTest() {
    Observable.fromIterable(listOf(B(), B(), B(), B(), B(), B(), B()))
            .compose {
                it.publish<B> { publish ->
                    val filteredList = publish.flatMapIterable { it.listOfA }
                            .filter {
                                it.filterable
                            }
                            .toList()
                            .toObservable()
                    Observable.zip<B, List<A>, B>(publish, filteredList, BiFunction<B, List<A>, B> { b, listOfA ->
                        B(b.name, listOfA)
                    })
                }
            }
}