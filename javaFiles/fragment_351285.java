Number result = (Number) getCurrentSession()
                .createSQLQuery("SELECT "
                        + "AVG(rating) "
                        + "FROM gio_prod_rating "
                        + "WHERE producto_id = :prodId")
                .setParameter("prodId", prodId)
                .uniqueResult()
return result != null ? result.doubleValue() : DEFAULT_AVG_VALUE;