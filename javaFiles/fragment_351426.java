for (Activity activity : diary){
    if (activity.getActivityType() == ActivityType.RUN) {
        distance[0] += activity.getDistance(); 
    } else if (activity.getActivityType() == ActivityType.CYCLE) {
        distance[1] += activity.getDistance();
    } else if (activity.getActivityType() == ActivityType.SWIM) {
        distance[2] += activity.getDistance();
    }
}