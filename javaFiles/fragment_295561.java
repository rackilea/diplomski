Collections.sort(glossary, new Comparator<Glossary>() {
    public int compare(Glossary a, Glossary b) {
        if (a == null) {
            if (b == null) {
                return 0;
            }
            return -1;
        } else if (b == null) {
            return 1;
        }
        int av = (a.getTerm() != null) ? a.getTerm().length() : 0;
        int bv = (b.getTerm() != null) ? b.getTerm().length() : 0;
        return Integer.valueOf(bv).compareTo(av);
    }
});