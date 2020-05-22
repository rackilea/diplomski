@Override
public Serializable generate(SessionImplementor session, Object obj) throws HibernateException {
    Connection connection = session.connection();
    try {
        Route route= ((Route ) obj);
        String seqName = "you_db_id_sequence";
        PreparedStatement ps = connection.prepareStatement("SELECT nextval ('" + seqName + "') as nextval");
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("nextval");
            log.info("Generated order id {} ", id);
            if (route.getRouteNumberId() == null) {
                route.setrouteNumberid(id); //or call another sequence to get a different id 
            }
            return Long.parseLong(code);
        } else {
           throw new IllegalStateException("could not generate new id");
        }
    } catch (SQLException e) {
        log.error("Could not generate id!", e);
        throw new HibernateException("Unable to generate id from Sequence");
    }
    return null;
}