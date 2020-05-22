public Query setParameter(String name, Object val) throws HibernateException {
    if (val == null) {
        Type type = parameterMetadata.getNamedParameterExpectedType( name );
        if ( type == null ) {
            type = StandardBasicTypes.SERIALIZABLE;
        }
        setParameter( name, val, type );
    }
    else {
        // determineType() method below is expensive
        setParameter( name, val, determineType( name, val ) );
    }