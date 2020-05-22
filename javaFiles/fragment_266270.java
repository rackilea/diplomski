public int sum(List<Integer> selectedCards) {
    int total;
    for (int card : selectedCards) {
        total += cardAt(card).pointValue();
    }
    return total;
}