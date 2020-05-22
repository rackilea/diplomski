public enum DAY { 

     SUNDAY("sunday"),
    MONDAY("monday"),
    TUESDAY("tuesday"),
    UNKNOWN("unknown");

    private final String value;

    DAY(final String value) {
        this.value = value;
    }

    private static final Map<String, DAY> VALUE_TO_TYPE = Stream.of(DAY.values()).collect(Collectors.toMap(d -> d.value, d -> d));

    public String value() {
        return value;
    }

   public static Optional<DAY> fromValue(final String value) {
       return Optional.ofNullable(VALUE_TO_TYPE.get(value));
   }
}