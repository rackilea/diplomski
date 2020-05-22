Stream.Builder<String> builder = Stream.<String>builder().add(required);
for (String s : additional) {
  builder.add(s);
}

Stream<String> allParams = builder.build();