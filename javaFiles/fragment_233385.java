QUser qUser = QUser.user;
JPQLQuery query = new JPAQuery(em);
User charlie = query
    .from(qUser)
    .where(qUser.username.eq("charlie"))
    .uniqueResult(qUser);