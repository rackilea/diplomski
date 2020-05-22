public enum Device {
    IPHONE, IPAD;

    public static Device byName(String name) {
      return Arrays.stream(values())
        .filter(d -> name.startsWith(d.toString()))
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException(String.format("Unknown device name %s", name)));
    }
  }