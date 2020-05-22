public static UserDeactivationThreshold getMinimumThresholdFor(String roleName, List<UserDeactivationThreshold> thresholds) {
    List<UserDeactivationThreshold> mins = new ArrayList<>();

    // first, fetch all items with the given role name into a list
    for (int i = 0; i < thresholds.size(); i++) {
        UserDeactivationThreshold udt = thresholds.get(i);

        if (udt.getRoleName().equals(roleName)) {
            mins.add(udt);
        }
    }

    // then create an instance to be returned, initialized with null
    UserDeactivationThreshold min = null;

    // now go through the list of items with the given role name
    for (int i = 0; i < mins.size(); i++) {
        // take the current item
        UserDeactivationThreshold current = mins.get(i);
        // check if minimum is still null
        if (min == null) {
            // if yes, set the minimum to the current item
            min = current;
        // if it is not null anymore, compare min's threshold to current's
        } else if (min.getThreshold() > current.getThreshold()) {
            // and set min to current if current has a lower threshold
            min = current;
        }
    }

    return min;
}