Player[] players = new Player[] {
    new Player("Bill", 29),
    new Player("Steve", 30),
    new Player("Toby", 15)
};

String playerTemplate = "<players:{ player |<player.name> is <player.age> <\\n>}>"
ST s = new ST( playerTemplate  );
s.add("players", Arrays.asList(players));
System.out.println(s.render());