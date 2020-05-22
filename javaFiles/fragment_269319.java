private final Handler<? super T> handler;
private final T info;

public Event(Handler<? super T> handler, T info) {
    this.handler = handler;
    this.info = info;
}