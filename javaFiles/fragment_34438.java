private void showDistance(ULocale locale) {
    int distance = 160;
    MeasurementSystem system = LocaleData.getMeasurementSystem(locale);
    String unit;
    if (system.equals(LocaleData.MeasurementSystem.SI)) {
        unit = "km";
    } else if (system.equals(LocaleData.MeasurementSystem.US)) {
        unit = "mi";
        distance = (int) (distance / 1.6);
    } else {
        throw new RuntimeException("Unknown measurement system.");
    }
    String distanceMessage = MessageFormat.format(
            "The distance between cities is {0} {1}.", distance, unit);
    System.out.println(distanceMessage);
}