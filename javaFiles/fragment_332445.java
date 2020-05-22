public static PTIModel convert(byte b) {
    for (PTIModel m : PTIModel.values()) {
        if (m.getValue() == b) {
            return m;
        }
    }
    throw new IllegalArgumentException(
            "invalid PTI model value (" + b + ")");
}