public class sp_session_callbacks extends Structure{
    public StdCallCallback logged_in;
    public StdCallCallback logged_out;
    public StdCallCallback connection_error;
    public StdCallCallback message_to_user;
}

sp_session_callbacks calls = new sp_session_callbacks();
calls.logged_out = new StdCallCallback(){

    public void someName(sp_session sp){...}
}