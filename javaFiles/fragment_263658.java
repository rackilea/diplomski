public Page< Area > searchAreaByNameAndCountryAndRegionAndDepartment( int page, int size, String name, String country, String region, String department ){

        QAtlas qAtlas = QAtlas.atlas;
        QArea qArea = QArea.area;

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        if( ! name.equals( "" ) ){
            booleanBuilder.and( qArea.name.containsIgnoreCase(name) );
        }
        if( ! country.equals( "" ) ){
            booleanBuilder.and( qAtlas.country.containsIgnoreCase(country) );
        }
        if( ! region.equals( "" ) ){
            booleanBuilder.and( qAtlas.region.containsIgnoreCase(region) );
        }
        if( ! department.equals( "" ) ){
            booleanBuilder.and( qAtlas.department.containsIgnoreCase(department) );
        }

        List<Area> areas = queryFactory.from(qAtlas)
                                   .innerJoin(qAtlas.areas, qArea)
                                   .where(booleanBuilder)
                                   .select(qArea)
                                   .fetch();

        long total = ( long ) areas.size( );

        return new PageImpl(areas, PageRequest.of( page, size ), total );
    }