Mono<Void> updateFoos(Flux<String> idFlux) {
        return idFlux                                         // Flux<String>
            .flatMap(id -> getFoo(id)                         // Mono<Foo>
                /*
                 * If a Foo with the given id is not found,
                 * create a new one, and continue the stream with it.
                 */
                .switchIfEmpty(insertFoo(id, new Foo()))      // Mono<Foo>
                /*
                 * Note that this is not an "else" condition
                 * to the above .switchIfEmpty
                 *
                 * The lambda passed to .flatMap will be
                 * executed with either:
                 * A) The foo found from getFoo
                 *    OR
                 * B) the newly inserted Foo from insertFoo
                 */
                .flatMap(foo -> getBar(foo.bar)               // Mono<Bar>
                    .flatMap(bar -> updateBar(foo, bar))      // Mono<Bar>
                    .then()                                   // Mono<Void>
                )                                             // Mono<Void>
            )                                                 // Flux<Void>
            .then();                                          // Mono<Void>
    }

    /*
     * @return the Foo with the given id, or empty if not found
     */
    abstract Mono<Foo> getFoo(String id);

    /*
     * @return the Bar with the given id, or empty if not found
     */
    abstract Mono<Bar> getBar(String id);

    /*
     * @return the Foo inserted, never empty
     */
    abstract Mono<Foo> insertFoo(String id, Foo foo);

    /*
     * @return the Bar updated, never empty
     */
    abstract Mono<Bar> updateBar(Foo foo, Bar bar);