from("file:src/main/resources/csv2?noop=true")
    .unmarshal(bindy)
    .wireTap("direct:logBody")
    .to("mock:result");

from("direct:logBody")
    .split().body()
    .log("Row# ${exchangeProperty.CamelSplitIndex} : ${name}");