ListValuedMap<Long, AnswerRow> groups = new ArrayListValuedHashMap<Long, AnswerRow>();
for (AnswerRow row : answerRows)
    groups.put(row.collectionId, row);
List<AnswerCollection> collections = new ArrayList<AnswerCollection>(groups.size());
for (Long collectionId : groups.keySet()) {
    AnswerCollection c = new AnswerCollection();
    c.addAll(groups.get(collectionId));
    collections.add(c);
}