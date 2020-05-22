static class SSGSessionStartTimeComparator extends Comparator<Map.Entry<String, SSGSession>>() {
    @Override
    public int compare(final Map.Entry<String, SSGSession> e1, final Map.Entry<String, SSGSession> e2) {
        return e2.getValue().getStartTime().compareTo(e1.getValue().getStartTime());
    }
}