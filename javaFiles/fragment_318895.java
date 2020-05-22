class InvocationWithArgumentsSpec extends Specification {
    void 'Invocation test works with arguments other then String'() {
        given:
        def subscriber = Mock(Subscriber)
        def simplePublisher = new Publisher()
        simplePublisher.subscribe(subscriber)
        def event = new SimpleEvent(name: 'test')

        when:
        simplePublisher.fireEvent(event)

        then:
        1 * subscriber.onEvent(event)
    }
}

interface Subscriber {
    void onEvent(SimpleEvent event)
}

class Publisher {
    Subscriber subscriber

    void subscribe(Subscriber subscriber) {
        this.subscriber = subscriber
    }

    void fireEvent(SimpleEvent event) {
        subscriber.onEvent(event)
    }
}

class SimpleEvent {
    String name
}