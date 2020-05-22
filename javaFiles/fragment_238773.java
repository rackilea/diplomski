private Flowable<String> generateFlowable(File file) {
  return Flowable.using(
          () -> Files.lines(file.toPath(), StandardCharsets.UTF_8),
          stream -> Flowable.fromIterable(stream::iterator),
          Stream::close
  );
}