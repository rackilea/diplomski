logUpdate(update, activity.getName(), name, "name", id);
activity.setName(name);

logUpdate(update, activity.getPlannedDuration(), plannedDuration,
          "planned duration", id);
activity.setPlannedDuration(plannedDuration);

...

static void logUpdate(boolean update, Object currentValue,
                      Object newValue, String field, String id) {
    if (currentValue == null) {
        logger.debug("      Setting " + field + " on " + id);
    } else if (!currentValue.equals(newValue)) {
        logger.debug("      Updating name on " + id);
    }    
}