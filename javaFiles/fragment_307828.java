class WordNodeComparator implements Comparator<WordNode> {
    @Override
    public int compare(WordNode lhs, WordNode rhs) {
        int result = lhs.getFrequency() - rhs.getFrequency();
        if (result == 0) {
            return lhs.getWord().compareTo(rhs.getWord());
        }
        else {
            return result;
        }
    }
}