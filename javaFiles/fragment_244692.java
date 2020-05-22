final JPAQuery query = new JPAQuery(entityManager);
final List<Tuple> myList = query
    .from(QPerson.person)
    .groupBy(QPerson.person.name)
    .where(myBooleanExpression)
    .list(QPerson.person.name, 
          new CaseBuilder()
              .when(yourOtherBooleanExpression).then(QPerson.person.cash.sum())
              .otherwise(yourOtherNumericExpressionOrLiteral));