private Day getDayWithNulls() {
    Day day = ... // call some method to create a Day instance,
                  // but don't call getDayWithNulls() !

    day.setTrainings(null);
    day.setMeasurements(null);
    day.setTrainingCycles(null);
    day.setDiets(null);
    day.setMeals(null);
    day.setLocalDate(LocalDate.now());

    return day;
}