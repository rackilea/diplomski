public class Model {
    private PlayerEntity player;
    private List<MonsterEntity> monsters;

    public void gameRound() {
        ...
    }

    public List<Entity> getEntities() {
        List<Entity> entities = Lists.newArrayList();
        entities.add(player);
        entities.addAll(monsters);
        ...
        return entities;
    }
}

...

public class View {
    private Model model;
    private List<Tile> tiles;

    public View(Model model) {
        this.model = model;
    }

    public void paintGame() {
        ...
        List<Entity> entities = model.getEntities();
        tiles = convertToTiles(entities);
        ...
        for (Tile tile : tiles) {
            tile.paintTile();
        }
        ...
    }

    private List<Tile> convertToTiles(List<Entity> entities) {
        ...
    }
}