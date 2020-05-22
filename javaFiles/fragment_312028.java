fun main(args: Array<String>) {
    val numbers = Observable.just("one", "two", "three")
    val languages = Observable.create<String> { emitter ->
        emitter.onNext("java")
        emitter.onNext("kotlin")
        emitter.onNext("swift")
        emitter.onComplete() // <-- Invoke this
    }

    languages
            .filter { s -> s.toLowerCase().startsWith("z") }
            .switchIfEmpty(numbers)
            .subscribe({
                System.out.println(it)
            }, {
                System.out.println(it)
            })

    numbers
            .filter { s -> s.toLowerCase().startsWith("z") }
            .switchIfEmpty(languages)
            .subscribe({
                System.out.println(it)
            }, {
                System.out.println(it)
            })


}