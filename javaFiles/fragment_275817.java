class Player {
    private String name;
    private String dungeonLevel;
    private float x;
    private float y;
    private float speed;
    // setters/getters go here
}

Player player = new Gson().fromJson(scanResult, Player.class);
Vector2 playerPosition = new Vector2(player.getX(), player.getY());