class HelloActor: AbstractActor<HelloActor.State>(), Hello
{
    override fun sayHello(greeting: String): Task<String> {
        val lastMessage = state().lastMessage
        state().lastMessage = greeting

        return Task.fromValue(lastMessage)
    }

    open class State {
        var lastMessage: String? = null
    }
}