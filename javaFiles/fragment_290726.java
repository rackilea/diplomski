// Cat membership in the Owner.cats relation using cartesian product
public static class Specs {
    static Specification<Cat> hasOwnerName(final String ownerName) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<Cat> cat = root;
            Root<Owner> owner = query.from(Owner.class);
            Expression<Collection<Cat>> ownerCats = owner.get("cats");
            return cb.and(cb.equal(owner.get("name"), ownerName), cb.isMember(cat, ownerCats));
        };
    }
}