from("file:/home/archivos/")
   .split(body().tokenize("\n"), new MyStrategyCSV())
       .choice()           
         .when(simple("${property.CamelSplitIndex} > 0"))
           .bean(BindingMDS.class, "processContent(${body})") 
         .otherwise()
           .bean(BindingMDS.class, "processHeader(${body})") // validate headers from csv and setup property in Exchange
      .end() // end choice
   .end() // end splitter
.to("direct:processNewContent");

from("direct:processNewContent")
    .bean(BindingMDS.class, "validateFile(${body})");