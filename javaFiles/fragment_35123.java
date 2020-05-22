for (int x = 0; x < 6; x++) {
    for (int y = 0; y < 6; y++) {
        RandomKleur kleur = new RandomKleur();
        tile[x][y] = new Tile(kleur.getKleur());
        //gridPanel.add(new myDots());
        gridPanel.add(new myDots(tile[x][y]));
    }
}