public void configure() throws Exception {
               from(IN_ENDPOINT).process(exchange -> {
                // Get the clientId from incoming msg and set it in exchange
                 exchange.setProperty("CLIENT_ID" , getClient()) 
                })
               .choice()
                  .when(isReadReq())
                    .to(readRouteBuilder)
                  .when(isWriteReq())
                    .to(writeRouteBuilder);