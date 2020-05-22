/**
     * Called upon entity UPDATE. For our BaseEntity, populates updated by with logged in user ID and
     * updated date-time.
     * <p>
     * Note that this method is called even if an object has NOT changed but someone's called a setter on
     * a Collection related to a child object (as opposed to modifying the Collection itself). Because of
     * that, the comparisons below are necessary to make sure the entity has really changed before setting
     * the update date and user.
     *
     * @see org.hibernate.EmptyInterceptor#onFlushDirty(java.lang.Object, java.io.Serializable, java.lang.Object[], java.lang.Object[], java.lang.String[], org.hibernate.type.Type[])
     */
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
            String[] propertyNames, Type[] types)
    {

        boolean changed = false;

        if (entity instanceof BaseEntity) {
            logger.debug("onFlushDirty method called on " + entity.getClass().getCanonicalName());

            // Check to see if this entity really changed(see Javadoc above).
            boolean reallyChanged = false;
            for (int i = 0; i < propertyNames.length; i++) {
                // Don't care about the collection types because those can change and we still don't consider
                // this object changed when that happens.
                if (!(types[i] instanceof CollectionType)) {
                    boolean equals = Objects.equals(previousState[i], currentState[i]);
                    if (!equals) {
                        reallyChanged = true;
                        break;
                    }
                }
            }

            if (reallyChanged) {
                String userId = somehowGetUserIdForTheUserThatMadeTheRequest();
                Date dateTimeStamp = new Date();

                // Locate the correct field and update it.
                for (int i = 0; i < propertyNames.length; i++) {
                    if (UPDATE_BY_FIELD_NAME.equals(propertyNames[i])) {
                        currentState[i] = userId;
                        changed = true;
                    }

                    if (UPDATE_DATE_FIELD_NAME.equals(propertyNames[i])) {
                        currentState[i] = dateTimeStamp;
                        changed = true;
                    }
                }
            }
        }

        return changed;
    }
}