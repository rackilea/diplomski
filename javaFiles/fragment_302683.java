public class MyEJB {

    @PersistenceContext
    private Session             session;

    public final void update(int param) {
        this.session.doWork(new UpdateWork(param));
    }

    private class UpdateWork implements Work {

        private final int param;

        public UpdateWork(int param) {
            this.param = param;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void execute(Connection connection) throws SQLException {
            PreparedStatement statement = connection.prepareStatement(query);
            int updated = statement.executeUpdate();
            statement.setInt(1,param);
            if (updated > 0) {
                // stuff
            }
        }
    }

}