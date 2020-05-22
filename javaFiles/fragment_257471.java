private static Predicate addTags(CriteriaBuilder cb, Root<News> news, SearchCriteria sc) {
    In<Object> in = cb.in(news.get("tagsSet").get("id"));

    for (Long id : sc.getTagIdsSet()) {
        in = in.value(id);
    }

    return in;
}