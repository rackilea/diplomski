public class Msg {

    public Msg(){

    }
    public Msg(String user, String msg) {
        this.user = user;
        this.msg = msg;
    }

    private String user, msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String message) {
        this.msg = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String username) {
        this.user = username;
    }
}