Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();
PreparedStatement st = session.connection().prepareStatement("{call procedureName(?, ?)}");
                st.setString(1, formatter.format(parameter1));
                st.setString(2, formatter.format(parameter2));
                st.execute();
tx.commit();