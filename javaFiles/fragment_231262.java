public boolean onPreInsert(PreInsertEvent event) {
    if (event.getEntity() instanceof BaseEntity) {
        Object obj = event.getEntity();
        BaseEntity entity = (BaseEntity) obj;
        boolean isMultiTenant = event.getEntity() instanceof BaseMultiTenantEntity;
        Object[] state = event.getState();
        String[] propertyNames = event.getPersister().getEntityMetamodel().getPropertyNames();

        Date createdTime = new Date();
        entity.setCreatedTime(createdTime);
        setValue(state, propertyNames, CREATED_TIME_PROPERTY, createdTime);

        Integer createdBy = getUserId();
        entity.setCreatedBy(createdBy);
        setValue(state, propertyNames, CREATED_BY_PROPERTY, createdBy);

        entity.setUpdatedTime(createdTime);
        setValue(state, propertyNames, UPDATED_TIME_PROPERTY, createdTime);

        entity.setUpdatedBy(createdBy);
        setValue(state, propertyNames, UPDATED_BY_PROPERTY, createdBy);

        if (isMultiTenant) {
            BaseMultiTenantEntity multiTenantEntity = (BaseMultiTenantEntity) obj;
            multiTenantEntity.setTenant(getTenant());
        }
    }
    return false;
}