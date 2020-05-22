CriteriaQuery<Long> countQuery = cb.createQuery( Long.class );
Root<Position> root = countQuery.from( Position.class );

countQuery.select( cb.count( root.get( "id" ) ) );

Subquery<Integer> subQuery = countQuery.subquery( Integer.class );
Root<Position> subRoot = subQuery.from( Position.class );
subQuery.select( cb.min( subRoot.get( "id" ) ) );
subQuery.groupBy( subRoot.get( "longitude" ), 
  subRoot.get( "latitude" ), 
  subRoot.get( "updateTime" ) );

countQuery.where( root.get( "id" ).in( subQuery ) );

Long count = entityManager.createQuery( countQuery ).getSingleResult();