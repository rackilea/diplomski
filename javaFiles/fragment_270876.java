Scheduler groupScheduler = Schedulers.newParallel("groupByPool", 16);
    Flux.fromStream(incomingMessages()) // stream of new data from socket
            .groupBy(Message::getEntityId) // split incoming messages by groups, which should be processed serially
            .map(g -> g.publishOn(groupScheduler)) //create new publisher for groups of messages
            .subscribe( //create consumer for main stream
                    stream ->
                            stream.subscribe(this::processMessage) // create consumer for group stream and process messagaes
            );