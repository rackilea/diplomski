from("direct:foo")
 .doTry()
  .to("direct:out")
 .doCatch(IOException.class)
  .process(urlChangeProcessor)
  .to("direct:foo")
 .end();

from("direct:out")
 .recipientList(simple("cxf:${exchangeProperty.targetUrl}?dataFormat=POJO"));