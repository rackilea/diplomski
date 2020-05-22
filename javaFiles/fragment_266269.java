public boolean differentRanks(List<Integer> selectedCards) {
    Set<Integer> ranks = new HashSet<Integer>();
    for (int card : selectedCards) {
        ranks.add(cardAt(card).rank());
    }
    return ranks.size() == selectedCards.size();
}