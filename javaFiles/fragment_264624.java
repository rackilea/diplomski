public static void createUser(String email, String password,
          String nome, String cognome, long telefono, String indirizzo,
          int cap, String città) throws Exception{

    Connection conn = MysqlConnection.getConnection();

    try{
        PreparedStatement st = conn.prepareStatement("INSERT INTO indirizzi
                (indirizzo, cap, città) VALUES (?,?,?)");
        st.setString(1, indirizzo);
        st.setInt(2, cap);
        st.setString(3, città);
        st.executeUpdate();

        /* You may want to close PreparedStatement here */

        st = conn.prepareStatement("INSERT INTO utenti
              (email, password, nome, cognome, telefono, idindirizzo)
              VALUES (?, ?, ?, ?, ?, LAST_INSERT_ID())");        
        st.setString(1, email);
        st.setString(2, password);
        st.setString(3, nome);
        st.setString(4, cognome);
        st.setLong(5, telefono);
        st.executeUpdate();
         /* You may want to close PreparedStatement here */
    }catch(Exception e){
        throw e;
    }finally{
        try{
            conn.close();
        }
        catch(SQLException e){
            throw e;
        }
    }
}