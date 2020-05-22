// initialized using instance initializer
Map<Pair<Integer, Integer>, String> streamIdAndSubjectIdMap = new HashMap<>()
{
    {
        put(new Pair(1, 1), "Accounts");
        put(new Pair(1, 2), "English");
        put(new Pair(1, 3), "Organization of Commerce");
    }
};

public String getSubjectFromStreamIdAndSubjectId(int streamId, int subjectId) {
    return streamIdAndSubjectIdMap.get(new Pair<>(streamId, subjectId));
}