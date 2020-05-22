Flux.range(1, 5) // produces elements from 1 to 5
        .delayElements(Duration.ofSeconds(1)) // delays emission of each element from above for 1 second
        .takeUntilOther(Mono
                .just(10) // hot publisher. emits one element

                // delays '10' for 3 seconds. meaning that it will only 
                // appears in the original Flux in 3 seconds
                .delayElement(Duration.ofSeconds(3)) 
        )
        .subscribe(System.out::print);