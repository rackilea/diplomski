public class LoginInfo {
    private String Command;
    private String uid;
    private Params params;

    public LoginInfo(Params userparams, String command, String uid) {
        this.params = userparams;
        Command = command;
        this.uid = uid;
    }
}