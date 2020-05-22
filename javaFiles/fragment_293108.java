public int getNumbers(List<Integer> studentNumbers, int x) {
    if (x >= 0 && x < studentNumbers.size()) {
        return studentNumbers.get(x);
    } else {
        return 0;
    }
}