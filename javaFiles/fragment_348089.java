//grabs the primaryKeyClass from generic type argument list (this was AbstractService<PK, T>)
    @SuppressWarnings("unchecked")
    protected Class<PK> primaryKeyClass = (Class<PK>) GenericTypeResolver.resolveTypeArguments(getClass(), AbstractService.class)[0];

    protected Class<PK> getPrimaryKeyClass() {
        return primaryKeyClass;
    }

    //code to retrieve generic list based on primary key
    public List<T> getEntitiesByPrimaryKey(List<PK> pks) {
        if(pks == null || pks.size() == 0)
            return new ArrayList<T>();

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        Root<T> root = cq.from(getEntityClass());

        Metamodel m = getEntityManager().getMetamodel();
        EntityType<T> T_ = m.entity(getEntityClass());
        Path<PK> keyPath = root.get(T_.getId(getPrimaryKeyClass()));

        cq.select(root);
        cq.where(keyPath.in(pks));

        List<T> entities = getEntityManager().createQuery(cq).getResultList();
        if(entities != null) {
            for (T entity : entities) {
                preProcessEntity(entity);
                fireEvent(entity, IEntityEventService.Event.READ, null);
            }
        }
        return entities;
    }