Collection<Integer> withTagIds = new ArrayList<Integer>();
for (Tag tag : withTags) {
    withTagIds.add(tag.getId());
}
q.where(license.tags.any().id.in(withTagIds));

Collection<Integer> withoutTagIds = new ArrayList<Integer>();
for (Tag tag : withoutTags) {
    withoutTagIds .add(tag.getId());
}
q.where(license.tags.any().id.in(withoutTagIds ).not());