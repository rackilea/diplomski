val delayDuration = Duration.ofMillis(200)
val maximumAttempts = 50

fun createDelayedMono(counter : Int) : Mono<BigInteger> {

    val mono = Mono.delay(delayDuration).flatMap {
        it ->

        if (counter < maximumAttempts && reactorHelper.isEventCompleted(rrn)) {
            reactorHelper.removeEvent(rrn)
            return@flatMap Mono.just(BigInteger.ZERO)
        } else {
            return@flatMap createDelayedMono(counter + 1)
        }

    }

    return mono
}