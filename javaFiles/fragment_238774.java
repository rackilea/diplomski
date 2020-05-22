private Flowable<String> generateFlowable(File file) {
  return Flowable.generate(
          () -> Files.newBufferedReader(Paths.get(file.toURI()), StandardCharsets.UTF_8),
          (reader, emitter) -> {
            String line = reader.readLine();
            if (line != null) {
              emitter.onNext(line);
            } else {
              emitter.onComplete();
            }
          }, BufferedReader::close);
}