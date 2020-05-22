TopologyBuilder builder = new TopologyBuilder();

// add the source processor node that takes Kafka topic "source-topic" as input
builder.addSource("Source", "source-topic")
       .addProcessor("Process", () -> new WordCountProcessor(), "Source")
       // Add the countStore associated with the WordCountProcessor processor
       .addStateStore(countStore, "Process")
       .addSink("Sink", "sink-topic", "Process");