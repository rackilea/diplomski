public static void main(String[] args) throws IOException {

    Game game = new Game();
    game.setId(171799578198L);
    game.setName("Forum Striking");

    Avatar avatar = new Avatar();
    avatar.setUserId(21393L);
    avatar.setClanId(171799578198L);
    avatar.setCurrentHomeId(21393L);

    Player player = new Player();
    player.setAvatar(avatar);
    game.addPlayers(player);

    avatar = new Avatar();
    avatar.setUserId(64425223942L);
    avatar.setClanId(171799578198L);
    avatar.setCurrentHomeId(64425223942L);

    player = new Player();
    player.setAvatar(avatar);
    game.addPlayers(player);

    System.out.println(new Gson().toJson(game));
}