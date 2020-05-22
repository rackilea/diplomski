Comparator<ScoreEntry> nameComparator = new Comparator<>(){
    public int compare(ScoreEntry first, ScoreEntry second) {
        int res = String.CASE_INSENSITIVE_ORDER.compare(first.name, second.name);
        if (res == 0)
            res = first.name.compareTo(second.name);
        return res;
    }
}