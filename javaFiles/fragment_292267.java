int Set<Integer> input = ...

// Build the power-set using the method from linked question
Set<Set<Integer>> power = powerSet(input);

int size = power.size() - 1;