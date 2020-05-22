public Map(Game game, String path) {
    this.game = game;
    //swapped the order of the lines below so the map loads first:
    loadMap(path);
    mapObjects = new MapObjects(game, "res/saves/save1_obj.txt", width, height);
}