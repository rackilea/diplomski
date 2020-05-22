public abstract class Entity {
    public void move() {
        ...
    }
}

...

public class PlayerEntity extends Entity {
    @Override
    public void move() {
        // User moves player
    }
}

...

public class MonsterEntity extends Entity {
    @Override
    public void move() {
        // Moved by A* algorithm
    }
}

...

public class Model {
    private PlayerEntity player;
    private List<MonsterEntity> monsters;

    public void gameRound() {
        ...
        player.move();
        ...
        for (MonsterEntity monster : monsters) {
            monster.move();
        }
        ...
    } 
}