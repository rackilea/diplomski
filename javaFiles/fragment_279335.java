@SessionScoped
@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

LoginDTO loginDTO = new LoginDTO();

public String logIn() {
   //here the logic
}

public LoginDTO getLoginDTO() {
    return loginDTO;
}

public void setLoginDTO(LoginDTO loginData) {
    this.loginDTO = loginData;
}