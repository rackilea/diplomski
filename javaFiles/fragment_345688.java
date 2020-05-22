public static String returnActualValue(String staffingEvent,
        String currentValue, String priorValue) {

    if ("TRM".equalsIgnoreCase(staffingEvent) && currentValue == null
            && priorValue != null && !"".equalsIgnoreCase(priorValue)) {
        return priorValue;
    } else {
        return currentValue;
    }
}