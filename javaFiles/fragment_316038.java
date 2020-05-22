from("timer:begin?repeatCount=1&delay=1")
.routeId("timer")
.to("direct:splitter-loop")
.log("Body after Loop Route: ${body}");

from("direct:splitter-loop")
.routeId("splitter-loop")
.process(exchange -> {
    // Add items that you want to iterate over to body or header
    // and later use splitter over those items.
    List<String> loopIndex = new ArrayList<String>();
    loopIndex.add("1");
    loopIndex.add("2");
    loopIndex.add("3");
    exchange.getOut().setBody(loopIndex);
})
.split(body(), new StringAggregator())
    .setBody().simple("Hello ${body}")
    .log("Body in Loop: ${body}")
.end()
.log("Body after Aggregate: ${body}");