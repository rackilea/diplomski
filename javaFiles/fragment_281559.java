if (update) {
    logUpdate(activity.getName(), name, "name", id);
    activity.setName(name);

    logUpdate(activity.getPlannedDuration(), plannedDuration,
             "planned duration", id);
    activity.setPlannedDuration(plannedDuration);
}