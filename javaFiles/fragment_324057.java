Predicate<Prices> pred = new Predicate<Prices>() {
    double sum = 0.0;
    boolean reached = false;
    public boolean test (Prices p) {
        sum += p.getPrice();
        if (sum >= 600.0) { // reached the sum
            if (reached) { // already reached the some before, reject element
                return false;
            } else { // first time we reach the sum, so current element is still accepted
                reached = true;
                return true;
            }
        } else { // haven't reached the sum yet, accept current element
            return true;
        }
    }
};

List<Prices> sublist = 
    input.stream()
         .takeWhile(pred)
         .collect(Collectors.toList());