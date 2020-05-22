// Subquery using Cat membership in the Owner.cats relation
public static class Specs {
    static Specification<Cat> hasOwnerName(final String ownerName) {
        return (root, query, cb) -> {
            query.distinct(true);
            Root<Cat> cat = root;
            Subquery<Owner> ownerSubQuery = query.subquery(Owner.class);
            Root<Owner> owner = ownerSubQuery.from(Owner.class);
            Expression<Collection<Cat>> ownerCats = owner.get("cats");
            ownerSubQuery.select(owner);
            ownerSubQuery.where(cb.equal(owner.get("name"), ownerName), cb.isMember(cat, ownerCats));
            return cb.exists(ownerSubQuery);
        };
    }
}