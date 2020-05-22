Query providetgetQuery;
if (providername.hasCombinedQueries()) {
    providetgetQuery = (Query) providername.getCombinedQueries().getQueryNodeAt(0);
} else {
    providetgetQuery = providername.getQuery();
}