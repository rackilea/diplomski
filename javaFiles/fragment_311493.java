eventStream.selectKey((key, value) -> new HistoryEventKey(key, value.getIdentifier()))
            .groupByKey(Grouped.<HistoryEventKey, HistoryEvent>as(null)
                    .withKeySerde(new HistoryEventKeySerde())
                    .withValueSerde(new HistoryEventSerde())
            )
            .reduce((e1, e2) -> e2,
                    Materialized.<HistoryEventKey, HistoryEvent, KeyValueStore<Bytes, byte[]>>as(streamByKeyStoreName)
                            .withKeySerde(new HistoryEventKeySerde()));