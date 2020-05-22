CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Job> cq = cb.createQuery(Job.class);
Root<Job> jobRoot = cq.from(Job.class);

// join the asset
Join<Job, Asset> assetJoin = jobRoot.join("asset");

// join the list of users
Join<Asset, User> assetUserJoin = assetJoin.join("userList");

cq.where(assetUserJoin.get("id").in(id));