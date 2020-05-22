final String queryString = "select distinct pos from Position pos " +
            "inner join pos.managersPositions mn " +
            "where mn.managerId = :managerId and mn.isDirect = :isDirect ";

    TypedQuery<Position> query = entityManager.createQuery(
            queryString,
            Position.class);
    query.setParameter("managerId", managerEmployeeId);
    query.setParameter("isDirect", true);