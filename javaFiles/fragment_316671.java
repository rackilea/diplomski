class MyEnums {
    private final Map<String, Class<? extends Enum<?>>> map = new HashMap<>();

    public void addEnum(Class<? extends Enum<?>> e) {
      map.put(e.getSimpleName(), e);
    }

    private <T extends Enum<T>> T parseUnsafely(String name) {
      final int split = name.lastIndexOf(".");
      final String enumName = name.substring(0, split);
      final String memberName = name.substring(split + 1);
      @SuppressWarnings("unchecked")
      Class<T> enumType = (Class<T>) map.get(enumName);
      return Enum.valueOf(enumType, memberName);
    }

    public Object parse(String name) {
      return parseUnsafely(name);
    }

    public Object[] parseAll(String... names) {
      return Stream.of(names)
          .map(this::parse)
          .collect(toList())
          .toArray();
    }
  }