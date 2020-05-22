// compile and run with cloud.orbit:orbit-runtime:1.2.0

import cloud.orbit.actors.runtime.AbstractActor
import cloud.orbit.actors.Actor
import cloud.orbit.actors.Stage
import cloud.orbit.concurrent.Task

class HelloActor: AbstractActor<HelloActor.ActorState>(), Hello
{
    override fun sayHello(greeting: String): Task<String> {
        val lastMessage = state().lastMessage
        state().lastMessage = greeting

        return Task.fromValue(lastMessage)
    }

    class ActorState {
        var lastMessage: String? = null
    }
}

interface Hello : Actor {
    fun sayHello(greeting: String): Task<String>
}

fun main(args : Array<String>) {
    val stage = Stage.Builder().clusterName("orbit-helloworld-cluster").build()
    stage.start().join()
    stage.bind()

    val helloActor = Actor.getReference(Hello::class.java, "0");

    var response = helloActor
            .sayHello("Welcome to orbit 1").join()

    println(response) // should print null

    response = helloActor
            .sayHello("Welcome to orbit 2").join()

    println(response) // should print "Welcome to orbit 1"

    stage.stop().join()
}