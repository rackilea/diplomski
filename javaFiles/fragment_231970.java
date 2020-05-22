final CompletionStage<IOResult> result = 
 .via(Framing.delimiter(ByteString.fromString(System.lineSeparator()),10000,FramingTruncation.ALLOW))
  FileIO.fromPath(filePath)
 .throttle(1, Duration.create(10, TimeUnit.SECONDS), 1, ThrottleMode.shaping())
 .to(printlnSink)
 .run(materializer);