static void applyWindowedWrite(PCollection<String> stream) {
    stream.apply(FileIO.<String, String>writeDynamic()
                .by(Event::getKey)
                .via(TextIO.sink())
                .to("gs://some_bucket/events/")
                .withDestinationCoder(StringUtf8Coder.of())
                .withNumShards(1)
                .withNaming(key -> FileIO.Write.defaultNaming(key, ".json")));
}