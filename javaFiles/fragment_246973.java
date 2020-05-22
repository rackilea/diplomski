public enum CallZone {

    CANADA, USA, EUROPE; //add any number of zones here

    public static boolean isValid(String zone) {
        return Stream.of(values())
                .anyMatch(s -> s.toString().equalsIgnoreCase(zone));
    }
}