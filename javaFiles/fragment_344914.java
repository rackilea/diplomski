final Path path = getTheFile().toPath();
final StreamingOutput output = o -> {
    final long copied = Files.copy(path, o);
    final boolean deleted = Files.deleteIfExists(path);
};
return Response.ok(output).build();