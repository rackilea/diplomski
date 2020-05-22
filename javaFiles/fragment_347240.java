public Assignment getMaxAssignmentFromCollection(Collection collection) {
    int max = Integer.MIN_VALUE;
    Assignment maxAssignment = null;
    for(Assignment element: collection) {
        if(element.getLevel() > max) {
            max = element.getLevel();
            maxAssignment = element;
        }
    }
    return maxAssignment;
}