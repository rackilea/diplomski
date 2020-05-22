List<Integer> digits(int i) {
    List<Integer> digits = new ArrayList<Integer>();
    while(i > 0) {
        digits.add(i % 10);
        i /= 10;
    }
    return digits;
}