public enum ParameterList {

    FREQUENCY_ID(Constants.FREQUENCY_ID_VALUE);

    private final String value;

    ParameterList(String value) {
        this.value= value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static class Constants {
        public static final String FREQUENCY_ID_VALUE = "500";
    }
}