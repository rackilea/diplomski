String GameLine;

while (scnr.hasNextLine()) {
    GameLine = scnr.nextLine();
    Management_System Game = new Management_System("", "", 0, 0, 0);
    String[] tags = GameLine.split(",");

    Game.setTitle(tags[0]);

    Game.setGenre(tags[1]);

    Game.setID(Double.parseDouble(tags[2]));

    Game.setRating(Integer.parseInt(tags[3]));

    Game.setQuantity(Integer.parseInt(tags[4]));

    add(Game);
}