// Aggregation

KTable<Windowed<String>, Event> results = groupedByKeyForWindow.aggregate(new AggregateInitiator(), new EventAggregator());

// This converstion causing changelog to output. Instead use next line.
KStream<String, AggregationMessage> aggregationMessageKStream = results.toStream((key, value) -> key.toString())
                .mapValues(this::convertToAggregationMessage).filter((k, v) -> v != null);

// output KTable to sample topic. But this output controlled by 
// COMMIT_INTERVAL_MS_CONFIG and CACHE_MAX_BYTES_BUFFERING_CONFIG parameters. 
// I'm using default values for these params.
results.to(windowedSerde, eventSerde,  "Sample");