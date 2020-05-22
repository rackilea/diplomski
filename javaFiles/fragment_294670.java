int hours = 2; // 2-hours interval

Criteria criteria = session.createCriteria( MyClass.class )
            .add( Restrictions.ge( "dataTs", start ) )
            .add( Restrictions.le( "dataTs", end ) );


ProjectionList projList = Projections.projectionList();
        projList.add( Projections.max( "value1" ) );
        projList.add( Projections.avg( "value2" ) );
        projList.add( Projections.sqlGroupProjection(
            String.format( "DATE_ADD( DATE( %s_.dataTs ), INTERVAL( HOUR( %s_.dataTs ) - HOUR( %s_.dataTs) %% %d ) HOUR) as hourly", criteria.getAlias(), criteria.getAlias(), criteria.getAlias(), hours ),
            String.format( "DATE_ADD( DATE( %s_.dataTs ), INTERVAL( HOUR( %s_.dataTs) - HOUR( %s_.dataTs ) %% %d ) HOUR)", criteria.getAlias(), criteria.getAlias(), criteria.getAlias(), hours ),
            new String[]{ "hourly" },
            new Type[]{ Hibernate.TIMESTAMP } )
        );
        criteria.setProjection( projList );

List results = criteria
            .setCacheable( false )
            .list();