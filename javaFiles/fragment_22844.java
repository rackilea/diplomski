HttpProcessor httpproc = <...>
HttpAsyncRequester requester = new HttpAsyncRequester(httpproc);
HttpHost target = new HttpHost("www.apache.org");
List<BasicAsyncRequestProducer> requestProducers = Arrays.asList(
    new BasicAsyncRequestProducer(target, new BasicHttpRequest("GET", "/index.html")),
    new BasicAsyncRequestProducer(target, new BasicHttpRequest("GET", "/foundation/index.html")),
    new BasicAsyncRequestProducer(target, new BasicHttpRequest("GET", "/foundation/how-it-works.html"))
);
List<BasicAsyncResponseConsumer> responseConsumers = Arrays.asList(
    new BasicAsyncResponseConsumer(),
    new BasicAsyncResponseConsumer(),
    new BasicAsyncResponseConsumer()
);
HttpCoreContext context = HttpCoreContext.create();
Future<List<HttpResponse>> future = requester.executePipelined(
    target, requestProducers, responseConsumers, pool, context, null);