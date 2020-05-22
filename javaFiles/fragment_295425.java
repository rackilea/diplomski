client.request(EU, Orders, ListOrdersRequest.forShipped(userData, LocalDateTime.now().minusDays(7), LocalDateTime.now().minusHours(2).minusMinutes(2)), ListOrdersResponse.class)
    .expand(e -> {
         if(e.getListOrdersResult().getNextToken() != null) {
             return client.request(EU, Orders, ListOrdersRequest.byNextToken(userData, e.getListOrdersResult().getNextToken()), ListOrdersByNextTokenResponse.class);
         }
         return Flux.empty();
     });