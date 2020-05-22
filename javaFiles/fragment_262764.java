Mono<Void> updateFoos(Flux<String> idFlux) {
        return idFlux                                         // Flux<String>
            .flatMap(id -> getFoo(id)                         // Mono<Foo>
                /*
                 * Map to a Tuple2 whose t2 indicates whether the foo was found.
                 * In this case, it was found.
                 */
                .map(foo -> Tuples.of(foo, true))             // Mono<Tuple2<Foo,Boolean>>
                /*
                 * If a Foo with the given id is not found,
                 * create a new one, and continue the stream with 
                 * a Tuple2 indicating it wasn't originally found
                 */
                .switchIfEmpty(insertFoo(id, new Foo())       // Mono<Foo>
                    /*
                     * Foo was not originally found, so t2=false
                     */
                    .map(foo -> Tuples.of(foo, false)))       // Mono<Tuple2<Foo,Boolean>>
                /*
                 * The lambda passed to .flatMap will be
                 * executed with either:
                 * A) t1=foo found from getFoo, t2=true
                 *    OR
                 * B) t1=newly inserted Foo from insertFoo, t2=false
                 */
                .flatMap(tuple2 -> tuple2.getT2()
                    // foo originally found 
                    ? getBar(tuple2.getT1().bar)              // Mono<Bar>
                        .flatMap(bar -> updateBar(tuple2.getT1(), bar)) // Mono<Bar>
                        .then()                               // Mono<Void>
                    // foo originally not found (new inserted)
                    : Mono.empty()                            // Mono<Void>
                )
            )                                                 // Flux<Void>
            .then();                                          // Mono<Void>
    }