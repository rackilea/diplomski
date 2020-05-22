public void deleteTeams(final Long acctId, final List<String> teams) {
        HibernateCallback<Integer> deleteCallback = new HibernateCallback<Integer>() {

        @Override
        public Integer doInHibernate(Session session)
                throws HibernateException, SQLException {

            return session.getNamedQuery(SparkTeam.DELETE_TEAMS)
                    .setParameter("p1", acctId)
                    .setParameterList("p2", teams)
                    .executeUpdate();
        }

    };
    getHibernateTemplate().execute(deleteCallback);
}