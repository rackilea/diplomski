Flux.generate(sink -> {
    val element = queue.peek();
    if (element == null) {
        sink.complete();
    } else {
        sink.next(element);
    }
});