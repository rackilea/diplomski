CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
CriteriaQuery<Sample> query = criteriaBuilder.createQuery(Sample.class);
MetaModel m = em.getMetaModel();
EntityType<Sample> entity = m.entity(Sample.class);
Root model = query.from(Sample.class);
query.where(criteriaBuilder.notEqual(model.get(entity.name), “”)).and(criteriaBuilder.notEqual(model.get(entity.name), null));