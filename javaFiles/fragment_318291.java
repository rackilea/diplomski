CriteriaBuilder cb = em.getCriteriaBuilder();
CriteriaQuery<Connection> q = cb.createQuery(Connection.class);
Root<Connection> conn = q.from(Connection.class);
Join<Connection, ConnectionGroup> connGrp = conn.join(Connection_.connectionGroups);
q.select(conn).distinct(true);
ParameterExpression<String> param = cb.parameter(String.class, "%"+ groupFilter + "%");
q.where(cb.like(connGrp.get(ConnectionGroup_name), param));