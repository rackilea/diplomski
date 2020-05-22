int i = 0;
while (scanner.hasNextLine()) {
    while (scanner.hasNext()) {
        players[i].Name = scanner.next();
        System.out.println(players[i].Name);
        i++;
    }
}