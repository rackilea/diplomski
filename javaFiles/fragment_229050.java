try {
        Statement stmt = database.connection.createStatement();
        ResultSet result = stmt.executeQuery("SELECT * FROM sampling_data d"
            + " WHERE EXISTS(SELECT * FROM entities e WHERE e.id = d.id)");
        List<Entity> entities = new ArrayList<Entity>();
        while (result.next()) {
            Entity entity = EntityFactory.createById(result);
            entities.add(entity);
        }
        result.close();
        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
    }