List<Player> players = new ArrayList<>();
//... add players
players.sort(Comparator.comparing(Player::getPoints).reversed());

System.out.println("Players:");
players.stream().forEach(p -> System.out.println("\t" + p));