public class LoginLogic {

LoginUI lu;

public LoginLogic() {
    lu = new LoginUI();

}

public LoginLogic(ResultSet rs) {
    lu = new LoginUI();
    process(rs);
}

private void process(ResultSet rs) {
    try {
        if (rs.next()) {
            lu.loginSuccess();

        } else {
            lu.loginFailed();
        }
    } catch (SQLException e) {
        // TODO: handle exception
    }
}

public static void main(String[] args) {

    /*/ Here you shld get your result rs first 

            con is your Connection object
            Statement stmt = con.createStatement(
            ResultSet.TYPE_SCROLL_INSENSITIVE,
            ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = stmt.executeQuery("SELECT yourColumn FROM yourTable");
    //*/

    new LoginLogic(rs);
}
}