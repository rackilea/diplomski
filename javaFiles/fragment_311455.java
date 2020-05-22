Session session = (Session) entityManager.getDelegate();
    session.doWork(new Work() {

        @Override
        public void execute(Connection connection) throws SQLException {
            PreparedStatement pStmt = null;
            try {
                pStmt = connection.prepareStatement(query);
                pStmt.execute();
            } finally {
                if (pStmt != null) {
                    pStmt.close();
                }                       
            }

        }
    });