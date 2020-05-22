public JoinFetchCapableRepositoryImpl(
                JpaMetamodelEntityInformation<T, ID> entityInformation,
                EntityManager entityManager) {

           this(entityInformation, entityManager, DEFAULT_ENTITY_PATH_RESOLVER);
       }