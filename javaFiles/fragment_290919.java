public Set<M> findOffsetValues(int offset,int limit) {
    PagingPredicate pagingPredicate = new PagingPredicate<>(getDefaultComporator(), limit);
    pagingPredicate.setPage(offset / limit);
    List<M> page = new ArrayList<>(itemsCacheMap.values(pagePredicate));
    pagePredicate.nextPage();
    page.addAll(itemsCacheMap.values(pagePredicate));
    int startIndex = offset % limit;
    return new LinkedHashSet<>(CollectionUtil.saveSublist(page, startIndex, startIndex + limit));
}