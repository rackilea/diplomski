new JPAQuery(em).from(entityQ).where( entityQ.id.in(

        new JPASubQuery()
        .from(entity2Q).innerJoin(entity2Q.objEntityQ, entityQ)
            .where(ENTITY, PREDICATE)                           
            .groupBy(entity2Q.objEntityQ.id)
            .having( Wildcard.count.goe(SIZE) )                 
        .list(entity2Q.objEntityQ.id)

    ))
    .offset(pageRequest.getOffset() )
    .limit( pageRequest.getPageSize() ) 
    .orderBy(ORDERS).list(entityQ);