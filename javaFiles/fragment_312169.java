public static Complex[] getComplexArray(double[] input) {
    Deque<Complex> deque = new LinkedList<Complex>();
    int size = (input.length / 4 + 1) * 2;
    for (int i = 0; i < size; i = i + 2) {
        deque.add(new Complex(input[i], input[i + 1]));
    }
    List<Complex> result = new ArrayList<Complex>(deque);
    deque.removeLast();
    while (deque.size() > 1) {
        result.add(deque.removeLast().conjugate());
    }
    return result.toArray(new Complex[result.size()]);
}