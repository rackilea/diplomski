Flux<Items> flux = Flux.fromIterable (nameList);
        Flux<WebSocketMessage> webSocketMessageFlux = flux
                .map(itm ->convertIemsToString(itm)).map (item -> webSocketSession.textMessage (item));


        return webSocketSession.send (webSocketMessageFlux);