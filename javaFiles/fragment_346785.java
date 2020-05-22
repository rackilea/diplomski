public class LoginLogic {

LoginUI lu;

public LoginLogic() {
    lu = new LoginUI();

}


public void process() {
    try {
        if (lu.getRs().next()) {
            lu.loginSuccess();

        } else {
            lu.loginFailed();
        }
    } catch (SQLException e) {
        // TODO: handle exception
    }
}

public static void main(String[] args) {

    LoginLogic loginLogic = new LoginLogic();
    loginLogic.process();
 }
 }