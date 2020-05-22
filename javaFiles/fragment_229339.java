String query = "SELECT cu FROM CompanyUser cu WHERE cu.id = :id";

CompanyUserId id = new CompanyUserId(1, 1);
TypedQuery<CompanyUser> q = entityManager.createQuery(query, CompanyUser.class);
q.setParameter("id", id);

CustomerUser user = q.getSingleResult();
user.setPrivilegeLevel(1);
entityManager.persist(user);