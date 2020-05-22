List results = q.getResultList();
if (results.size() == 0) {
    return Collections.emptyList();
} else {
    return results;
}