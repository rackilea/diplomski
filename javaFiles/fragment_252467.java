public int findMax() {
    if (next == null) {
        return value;
    }
    else {
        int maxOfRest = next.findMax();
        if(value <= maxOfRest) {
            return maxOfRest;
        }
        else return value;
    }
}