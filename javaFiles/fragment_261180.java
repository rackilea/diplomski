// Get the criteria builder from the entity manager
CriteriaBuilder cb = manager.getCriteriaBuilder();

// Create a new criteria instance for the main query, the generic type indicates overall query results
CriteriaQuery<RoleEntity> c = cb.createQuery(RoleEntity.class);
// Root is the first from entity in the main query
Root<RoleEntity> role = criteriaQuery.from(RoleEntity.class);

// Now setup the subquery (type here is RETURN type of subquery, should match the users.role)
Subquery<RoleEntity> sq = cb.subquery(RoleEntity.class);
// Subquery selects from users
Root<UserEntity> userSQ = sq.from(UserEntity.class);
// Subquery selects users.role path, NOT the root, which is users
sq.select(userSQ.get(UserEntity_.role))
  .where(cb.equal(userSQ.get(UserEntity_.username), username)); // test for name="somename"

// Now set the select list on the criteria, and add the in condition for the non-correlated subquery
c.select(role)
  .where(cb.in(role).value(sq));  // can compare entities directly, this compares primary key identities automatically