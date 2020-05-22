public int addAccount(Accounts bean) {

    int count=0; 
    try {
        bConnector = new DBConnector();
        Connection c = bConnector.getConnection();
        String query = "insert into account (username, name, email, password) values (?,?,?,?)";
        PreparedStatement preparedstatement = c.prepareStatement(query);
        preparedstatement.setString(1, bean.getUsername());
        preparedstatement.setString(2, bean.getName());
        preparedstatement.setString(3, bean.getEmail());
        preparedstatement.setString(4, bean.getPassword());
        count=preparedstatement.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(AccountsDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
 return count;
}