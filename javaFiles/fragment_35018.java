public class PlayerPlugin extends CordovaPlugin {

    private HashMap<int, Player> players = new HashMap<int, Player>();

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("create")) {
            this.create(args, callbackContext);
            return true;
        }else if (action.equals("move")) {
            this.move(args, callbackContext);
            return true;
        }else if (action.equals("get")) {
            this.get(args, callbackContext);
            return true;
        }
        return false;
    }

    private void create(JSONArray args, CallbackContext callbackContext) {
            int health = args.getInt(0); 
            int gold = args.getInt(1);
            Player player = new Player(health, gold);
            players.put(player.id, player);
            callbackContext.success(player.id);
    }

    private void move(JSONArray args, CallbackContext callbackContext) {
        int playerId = args.getInt(0);
        String area = args.getString(1); 
        if (area != null && area.length() > 0) { 
            Player player = players.get(playerId);
            player.area = area;
            callbackContext.success();
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void get(JSONArray args, CallbackContext callbackContext) {
        int playerId = args.getInt(0);
        Player player = players.get(playerId);

        JSONObject jsPlayer = new JSONObject();
        jsPlayer.put("health", player.health);
        jsPlayer.put("gold", player.gold);
        jsPlayer.put("area", player.area);
        callbackContext.success(jsPlayer);
    }
}

public class Player {
    private static int idCounter = 0;
    private int id;
    private int health;
    private int gold;
    private String area = "Home";

    public Player(health,gold) {
        this.health = health;
        this.gold = gold;
        this.id = idCounter++;
    }
}