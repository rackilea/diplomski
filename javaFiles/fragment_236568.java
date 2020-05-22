String name2 = scan.nextLine();
for (int i = 0; i < numPlayers; i++) {
    System.out.println("We have entered the loop.");
    if (name2.equals(players[i].name)) {
        players[i].loss++;
        break;
    }
}