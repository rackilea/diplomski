for (int i = 0; i <= numOfPlayers; i++) {
    System.out.println("What is your name? ");
    String name = scan.next();
    System.out.println("Choose a color (Red, blue, green, yellow)");
    String color = scan.next();
    int id = i+1;
    players.add(new Player(name, id, color));
}