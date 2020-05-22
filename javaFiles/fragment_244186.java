public synchronized void killProcesses(Set<Long> ids) {
    for (long id : ids) {
        String killCommand="KILL QUERY " + id;
        queryManager.getTransaction().begin();
        Connection conn=queryManager.unwrap(Connection.class);
        try {
            Statement statement= conn.createStatement();
            statement.execute(killCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
                queryManager.getTransaction().commit();
                conn.close();   
        }

    }
}