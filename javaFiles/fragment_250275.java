public void one() {
    two();
    // continue here from condition
}

public void two() {
    if (three()) {
        // go back due to condition 
        return;
    }

    // condition wasn't met
}

public boolean three() {
    // some condition is determined here

    if (condition) {
        // exits two() and three() and continues back in one()
        return true;
    }

    // condition wasn't met, keep processing here

    // finally return false so two() keeps going too
    return false;
}