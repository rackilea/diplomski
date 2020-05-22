private static final Map<StringClassification, Function<String, List<String>>> PROCESSORS;
  static {
    PROCESSORS = new EnumMap<>(StringClassification.class);
    PROCESSORS.put(StringClassification.CONTAINS_HYPHEN, l -> Arrays.stream(l.split("-")).collect(Collectors.toList()));
    PROCESSORS.put(StringClassification.LENGTH_GT_30, l -> Arrays.asList(new String[] { l }));
    PROCESSORS.put(StringClassification.DEFAULT, l -> Arrays.asList(new String[] { l + "|" }));
  }