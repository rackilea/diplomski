mathApi.multiplyByTwo(1)
    .flatMap {
        mathApi.multiplyByTwo(it)
    }.flatMap {
        mathApi.multiplyByTwo(it)
    }.subscribe {
        // here "it" will be 4 (1*2*2) 
    }