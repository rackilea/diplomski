private void login() {
    try {
        if (user != null && pass != null) {
            String sql = "Select * from users_table Where username='" + user + "' and password='" + pass + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                //in this case enter when at least one result comes it means user is valid
            } else {
                //in this case enter when  result size is zero  it means user is invalid
            }
        }

        // You can also validate user by result size if its comes zero user is invalid else user is valid

    } catch (SQLException err) {
        JOptionPane.showMessageDialog(this, err.getMessage());
    }

}