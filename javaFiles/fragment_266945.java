Connection conn = em.unwrap(Connection.class);
    Statement st = conn.createStatement();
    for(EntityType<?> et : emf.getMetamodel().getEntities()) {
        String query = "SELECT * FROM " + et.getName();
        System.out.println("> " + query);
        st.execute(query);
        JDBCDisplayUtil.DisplayResults(System.out, st, conn);
    }