int i = 0;
while ((i < 10) && scanner.hasNextLine()) {
    while ((i < 10) && scanner.hasNext()) {
        players[i].Name = scanner.next();
        System.out.println(players[i].Name);
        i++;
    }
}