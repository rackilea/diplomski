public void addDemande(DemandeInscription demande) {
    Connection conn = null;
    String url = "jdbc:mysql://my-ip:3306/my-database-name?useSSL=false";
    String driver = "com.mysql.jdbc.Driver";

    String userName = "my-username";
    String password = "my-password";
    // List<DemandeInscription> demandes = new ArrayList<DemandeInscription>();
    try {

        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url, userName, password);

        PreparedStatement st = conn
                .prepareStatement("insert into demandeInscription(name, city, address, food, type, email) values( ?, ?, ?, ?, ?, ?)");
        st.setString(1, demande.getName());
        st.setString(2, demande.getCity());
        st.setString(3, demande.getAddress());
        st.setString(4, demande.getFood());
        st.setString(5, demande.getType());
        st.setString(6, demande.getEmail());

        // Turn off auto-commit 
        conn.setAutoCommit(false);

        // Uncommented this statement that actually does the update
        int result = st.executeUpdate();

        // Commit the change
        conn.commit();

        // Release the resource
        st.close();

    } catch (SQLException ex) {
        ex.printStackTrace();
    } catch (InstantiationException ex) {
        ex.printStackTrace();
    } catch (IllegalAccessException ex) {
        ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
}