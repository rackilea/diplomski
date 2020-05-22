workObjectMap.compute(key, (k,v) -> {
    if (v == null) return new WorkObjectValue(memberIdSet, memberPositionSet);
    v.memberIdSet.addAll(memberIdSet);
    v.memberPositionSet.addAll(memberPositionSet);
    return v;
});