for (Activity activity : diary){
    if (activity instanceof Run) {
        distance[0] += activity.getDistance(); 
    } else if (activity instanceof Cycle) {
        distance[1] += activity.getDistance();
    } else if (activity instanceof Swim) {
        distance[2] += activity.getDistance();
    }
}