public void deleteData(Session session, int minVal, int maxVal) throws SQLException {
    session.doWork(new Work() {
                @Override
                public void execute(Connection connection) throws SQLException {
                    CallableStatement st = null;
                    st = connection.prepareCall("{call delete_data(?,?)}");
                    st.setInt(1, minVal);
                    st.setInt(2, maxVal);
                    st.execute();
                    st.close();
                }
            }); 

    }