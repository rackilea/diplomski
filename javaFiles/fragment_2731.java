private CharArraySet getNoStemmingSet(String query) {
    if (query != null && !query.contains(" -")) {
        return new CharArraySet(Version.LUCENE_41, Collections.emptyList(), true);
    }

    List<String> proihibitedClauses = new ArrayList<String>();

    for (String clause : query.split("\\s")) {
        if (clause.startsWith("-")) {
            proihibitedClauses.add(clause.replace("-", ""));
        }
    }

    return new CharArraySet(Version.LUCENE_41, proihibitedClauses, true);
}