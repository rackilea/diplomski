public class Session {

    private final SessionActions actions;
    private final RequestFabric requests;
    private final Player player;

    public Session (SessionActionFabric actionsFabric,
                    RequestFabric requests, Player player) {
        this.actionsFabric = actionsFabric;
        this.requests = request;
        this.player = player;
    }

    void login() throws LoginException {
        Request request = request.createRequest();
        SessionAction login = actions.createActions("login", player, request);
        login.performAction();
        //something like that it's depends on whole picture of your project and maybe changed
    }

    //etc.
}

public interface Request {

    public performRequest(Player player, /*request data your api specs here*/) throws RequestException;
}

public class Player {

    private String id;
    private String name;

   public Player(String id, String name){
       this.id = id;
       this.name = name;
   }

   //getters, setters 
}

interface SessionAction {

    void performAction() throws SessionActionException;
}

class LoginAction implements SessionAction {
    private final Player player;
    private final Request request;


    LoginAction (Player player, Request request) {
        this.player = player;
        this.request = request;
    }

    void performAction() {
        // do you things here
    }

}