public static void main(String[] args) {
    Game game = new Game();
    Command command = new Command(game); // *** note constructor change
    command.changeX();
    System.out.println(game.getX());
}