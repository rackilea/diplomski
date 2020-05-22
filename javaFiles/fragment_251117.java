root = criteriaQuery.from(Organization.class);
Join<Organization, Set<Tin>> resource = root.join("tin");
criteriaQuery = criteriaQuery.select(root);
Predicate predicate = criteriaBuilder.equal(resource.get(NAME_COLUMN), "name");
criteriaQuery.where(predicate);
entityManager.createQuery(criteriaQuery);