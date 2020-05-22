@Test
public void works() {
    String path = OS.TMP + "/chronicle-" + System.nanoTime();
    System.out.println("Using temp path " + path);

    try (SingleChronicleQueue queue = SingleChronicleQueueBuilder
            .single()
            .path(path)
            .build()) {

        ExcerptAppender appender = queue.acquireAppender();
        Messager messager = appender.methodWriter(Messager.class);

        int numberOfRecords = 10;

        // Write
        for (int i = 0; i <= numberOfRecords; i++) {
            System.out.print("Writing " + i);
            messager.msg("Hello World!");
            System.out.println(", your data was stored at index=" + appender.lastIndexAppended());
        }

        ExcerptTailer tailer = queue.createTailer();
        MethodReader reader = tailer.methodReader((Messager) msg -> {
            System.out.println("Current offset: " + tailer.index()
                    + " msg: " + msg);
        });

        // Read
        while (reader.readOne()) {
            // busy wait.
        }
    }
}