public class World {
    Tile[][] coordinates;
    List<Tile> tiles = new ArrayList<>();

    // Creates an instance of a map with a user-defined size
    public World(int width, int height) {
        coordinates = new Tile[width][height];
        for(int i = 0; i<width; i++){
            for(int j = 0; j<height; j++){
                coordinates[i][j] = new Tile(i,j);
                tiles.add(coordinates[i][j]);
            }
        }
    }

    public void addEntity(Entity e){
        int x = e.getX();
        int y = e.getY();
        coordinates[x][y].addEntity(e);
    }
    public void setTileType(int x, int y, String type){
        coordinates[x][y].setType(type);
    }
    public List<Tile> getTiles(){
        return new List<>(tiles);
    }

    public List<Entity> getEntities(){
       List<Entity> entities = new ArrayList<>();
       for(Tile[] row: coordinates){
           for(Tile tile: row){
               entities.addAll(tile.entities);
           }
       }
    }
}