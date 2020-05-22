if (carry > 0) {
    solution.set(0, carry);
    return solution.toArray(new Integer[] {});
} else {
    return solution.subList(1, solution.size()).toArray(new Integer[] {});
}