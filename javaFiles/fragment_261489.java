/* Axon configuration */
    Configuration config = DefaultConfigurer.defaultConfiguration()
            .configureAggregate(GiftCard.class)
            // .configureEmbeddedEventStore(c -> new InMemoryEventStorageEngine())
            .eventProcessing(ep -> ep.registerEventHandler(c -> new GiftCardEventHandler(c.queryUpdateEmitter(), querySideDBMap)))
            .registerQueryHandler(c -> new GiftCardQueryHandler(querySideDBMap))
            .start();