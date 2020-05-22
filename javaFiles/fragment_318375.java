public List<Tag> filterTags(List<Tag> tags) {
    Criteria criteria = session.createCriteria(Tag.class);
    Disjunction disjunction = Restrictions.disjunction();

    for (Tag tag : tags) {
        disjunction.add(Restrictions.eq("name", tag.getName()));
    }
    criteria.add(disjunction);
    return criteria.list();
}