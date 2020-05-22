State bestSolution; // add this global

public static State solveIDAStar(State initialState) {
    int limit = initialState.getManhattanDistance() + 2 * initialState.getLinearConflicts();
    bestSolution = null; // reset global to null
    State result = null;
    while(result == null) {
        visitedStates.add(initialState); // It's a global variable
        newLimit = INFINITY;
        result = limitedSearch(initialState, limit);
        limit = newLimit;
        visitedStates.clear();
    }
    return result;
}

public static State limitedSearch(State current, int limit) {
    for(State s : current.findNext()) {
        if(s.equals(GOAL)) {
            s.setParent(current);
            return s;
        }
        if(!visitedStates.contains(s)) {
            s.setPathCost(current.getPathCost() + 1);
            s.setParent(current);
            int currentCost = s.getManhattanDistance() + 2 * s.getLinearConflicts() + s.getPathCost();
            if(currentCost <= limit) {
                visitedStates.add(s);
                State solution = limitedSearch(s, limit);
                if(solution != null &&
                   (bestSolution == null || solution.getPathCost() < bestSolution.getPathCost()))
                        bestSolution = solution; // cache solution so far
            } else {
                if(currentCost < newLimit)
                    newLimit = currentCost;
            }
        }
    }
    return null;
}