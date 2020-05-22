<T> Source<T, Callback<T>> callbackSource() {
    return Source.queue(1024, OverflowStrategy.fail())
        .mapMaterializedValue(queue -> new Callback<T> {
            // an implementation of Callback which pushes the data
            // to the queue
        });
}

Source<Integer, Callback<Integer>> source = callbackSource();

Callback<Integer> callback = source
    .toMat(Sink.foreach(System.out::println), Keep.left())
    .run(materializer);

thirdPartyApiObject.runSomethingWithCallback(callback);