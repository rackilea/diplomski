public Set<List<Pair>> compute(List<Integer> numbers) {
    if(numbers.size() < 3) {
            // Base case
        List<Pair> list = new ArrayList<>();
        list.add(new Pair(numbers));
        Set<List<Pair>> result = new HashSet<>();
        result.add(list);
        return result;
    } else {
        Set<List<Pair>> result = new HashSet<ArrayList<>>();
        // We take each pair that contains the 1st element
        for(int i = 1; i < numbers.size(); i++) {
            Pair first = new Pair(numbers.get(0), numbers.get(i));
            // This is the input for next level of recursion
            // Our numbers list w/o the current pair
            List<Integers> nextStep = new ArrayList<>(numbers);
            nextStep.remove(i);
            nextStep.remove(0);
            Set<List<Pair>> intermediate = null;
            if(nextStep.size() % 2 == 0) {
                intermediate = compute(nextStep);
            } else {
                intermediate = compute(numbers).addAll( firstElementSingle(numbers) ),compute( nextStep );
            }
            for(List<Pair> list : intermediate ) {
                // We add the current pair at the beginning
                list.add(0, first);
            }
            result.addAll(intermediate);
        }
        return result;
    }
}