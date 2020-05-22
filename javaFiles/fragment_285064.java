CompletionStage<IOResult> ioResult =
    FileIO.fromPath(file)
          .via(Framing.delimiter(ByteString.fromString(System.lineSeparator()), 1000, FramingTruncation.ALLOW))
          .throttle(1, Duration.create(1, TimeUnit.SECONDS), 1, ThrottleMode.shaping())
          .to(printlnSink)
          .run(materializer);