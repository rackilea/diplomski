import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SenderData")
public class Account {
    private String login, password;

    public String getLogin() {
        return login;
    }

    /*public void setLogin(String login) {
        this.login = login;
    }*/

    public String getPassword() {
        return password;
    }

    /*public void setPassword(String password) {
        this.password = password;
    }*/


    public void toPtring(){
        System.out.println("login="+this.getLogin());
        System.out.println("pass="+this.getPassword());
    }
}