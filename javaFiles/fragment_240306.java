if (myFilter.getTerm1() != null) {
    qb.must(QueryBuilders.matchQuery("myfield1", myFilter.getTerm1()));
}

if (myFilter.getTerm2() != null) {
    qb.must(QueryBuilders.matchQuery("myfield2", myFilter.getTerm2()));
}