int i = 0;
while (scanner.hasNextLine()) {
    if (scanner.hasNext()) {
        players[i].Name = scanner.next();
        System.out.println(players[i].Name);
        i++;
    }
}