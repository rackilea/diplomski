public static Stream<Activity> getChildren(Activity activity) {
    List<Activity> activities = new LinkedList<>();
    recursiveCall(activities, activity);

    return activities.stream();
}

public static void recursiveCall(List<Activity> activities, Activity activity) {
    if(activity.children.isEmpty()) {
        return;
    }

    activity.getChildren().forEach(child -> {
        activities.add(child);
        recursiveCall(activities, child);
    });
}