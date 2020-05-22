// HACK ALERT!!
    Field field = TypeFactory.class.getDeclaredField( "BASIC_TYPES" );
    field.setAccessible( true );
    Map basicTypes = (Map)field.get( null );

    field = basicTypes.getClass().getDeclaredField( "m" );
    field.setAccessible( true );
    Map underlyingMap = (Map)field.get( basicTypes );

    underlyingMap.put( SomeType.class.getName(), Hibernate.custom( MyCustomUserType.class ) );