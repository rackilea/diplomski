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
    private Presenter presenter;
    private List<Tile> tiles;

    public View(Presenter presenter) {
        this.presenter = presenter;
    }

    public void paintGame() {
        ...
        List<Tile> tiles = presenter.getTiles();
        ...
        for (Tile tile : tiles) {
            tile.paintTile();
        }
        ...
    } 
}

...

public class Presenter {
    private Model model;

    public Presenter(Model model) {
        this.model = model;
    }

    public List<Tile> getTiles() {
        return convertToTiles(model.getEntities());
    } 

    private List<Tile> convertToTiles(List<Entity> entities) {
        ...
    }
}