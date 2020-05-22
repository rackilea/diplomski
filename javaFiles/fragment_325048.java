.when(method(MySplitterBean.class,"splitBody").isEqualTo("US"))
    ...        
    .enrich("direct:getCarrierData", aggregationStrategy)
    ...;

from("direct:getCarrierData")
    .setHeader(Exchange.HTTP_METHOD,constant("GET"))
    .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
    .to("http://localhost:8081/US")