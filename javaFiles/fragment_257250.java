public class MainGame extends ApplicationAdapter {

    @Override
    public void create() {
        final Player player0 = new Player();
        final Player player1 = new Player();
        final Fleet fleet0 = new Fleet(player0);
        player0.fleets.add(fleet0);
        final Fleet fleet1 = new Fleet(player1);
        player1.fleets.add(fleet1);

        GameState state = new GameState();
        state.players.add(player0);
        state.players.add(player1);
        state.fleets.add(fleet0);
        state.fleets.add(fleet1);


        final Json json = new Json();
        final String infiniteLoopOrStackOverflowErrorHappensHere = json.toJson(state.toGameSaveState());
        state = json.fromJson(GameSaveState.class, infiniteLoopOrStackOverflowErrorHappensHere).toGameState();
    }
}

public abstract class BaseEntity {
    private static long idCounter = 0;

    public final long id;

    BaseEntity() {
        this(idCounter++);
    }

    BaseEntity(final long id) {
        this.id = id;
    }
}

public abstract class BaseSnapshot {
    public final long id;

    BaseSnapshot(final long id) {
        this.id = id;
    }
}

public class Fleet extends BaseEntity {
    public Player owner;

    Fleet(final long id) {
        super(id);
    }

    public Fleet(final Player owner) {
        this.owner = owner;
        //this.owner.fleets.add(this); --> Removed because this is a side-effect!
    }

    public FleetSnapshot toSnapshot() {
        return new FleetSnapshot(id, owner.id);
    }


    public static class FleetSnapshot extends BaseSnapshot {
        public final long ownerId;

        //Required for serialization
        FleetSnapshot() {
            super(-1);
            ownerId = -1;
        }

        public FleetSnapshot(final long id, final long ownerId) {
            super(id);
            this.ownerId = ownerId;
        }

        public Fleet toFleet(final Map<Long, BaseEntity> entitiesById) {
            final Fleet fleet = (Fleet)entitiesById.get(id);
            fleet.owner = (Player)entitiesById.get(ownerId);
            return fleet;
        }
    }
}

public class GameSaveState {
    public final Array<PlayerSnapshot> playerSnapshots;
    public final Array<FleetSnapshot> fleetSnapshots;

    //required for serialization
    GameSaveState() {
        playerSnapshots = null;
        fleetSnapshots = null;
    }

    public GameSaveState(final Array<PlayerSnapshot> playerSnapshots, final Array<FleetSnapshot> fleetSnapshots) {
        this.playerSnapshots = playerSnapshots;
        this.fleetSnapshots = fleetSnapshots;
    }

    public GameState toGameState() {
        final Map<Long, BaseEntity> entitiesById = constructEntitiesByIdMap();

        final GameState restoredState = new GameState();
        restoredState.players = restorePlayerEntities(entitiesById);
        restoredState.fleets = restoreFleetEntities(entitiesById);
        return restoredState;
    }

    private Map<Long, BaseEntity> constructEntitiesByIdMap() {
        final Map<Long, BaseEntity> entitiesById = new HashMap<Long, BaseEntity>();

        for (final PlayerSnapshot playerSnapshot : playerSnapshots) {
            final Player player = new Player(playerSnapshot.id);
            entitiesById.put(player.id, player);
        }

        for (final FleetSnapshot fleetSnapshot : fleetSnapshots) {
            final Fleet fleet = new Fleet(fleetSnapshot.id);
            entitiesById.put(fleet.id, fleet);
        }

        return entitiesById;
    }

    private Array<Player> restorePlayerEntities(final Map<Long, BaseEntity> entitiesById) {
        final Array<Player> restoredPlayers = new Array<Player>(playerSnapshots.size);
        for (final PlayerSnapshot playerSnapshot : playerSnapshots) {
            restoredPlayers.add(playerSnapshot.toPlayer(entitiesById));
        }
        return restoredPlayers;
    }

    private Array<Fleet> restoreFleetEntities(final Map<Long, BaseEntity> entitiesById) {
        final Array<Fleet> restoredFleets = new Array<Fleet>(fleetSnapshots.size);
        for (final FleetSnapshot fleetSnapshot : fleetSnapshots) {
            restoredFleets.add(fleetSnapshot.toFleet(entitiesById));
        }
        return restoredFleets;
    }
}

public class GameState {
    public Array<Player> players = new Array<Player>();
    public Array<Fleet> fleets = new Array<Fleet>();

    public GameSaveState toGameSaveState() {
        final Array<PlayerSnapshot> playerSnapshots = new Array<PlayerSnapshot>(players.size);
        final Array<FleetSnapshot> fleetSnapshots = new Array<FleetSnapshot>(fleets.size);

        for (final Player player : players) {
            playerSnapshots.add(player.toSnapshot());
        }

        for (final Fleet fleet : fleets) {
            fleetSnapshots.add(fleet.toSnapshot());
        }

        return new GameSaveState(playerSnapshots, fleetSnapshots);
    }
}

public class Player extends BaseEntity {
    public Array<Fleet> fleets = new Array<Fleet>();

    public Player () {}

    Player (final long id) {
        super(id);
    }

    public PlayerSnapshot toSnapshot() {
        final Array<Long> fleetIds = new Array<Long>(fleets.size);
        for(final Fleet fleet : fleets) {
            fleetIds.add(fleet.id);
        }

        return new PlayerSnapshot(id, fleetIds);
    }


    public static class PlayerSnapshot extends BaseSnapshot {
        public final Array<Long> fleetIds;

        //Required for serialization
        PlayerSnapshot() {
            super(-1);
            fleetIds = null;
        }

        public PlayerSnapshot(final long id, final Array<Long> fleetIds) {
            super(id);
            this.fleetIds = fleetIds;
        }

        public Player toPlayer(final Map<Long, BaseEntity> entitiesById) {
            final Player restoredPlayer = (Player)entitiesById.get(id);
            for (final long fleetId : fleetIds) {
                restoredPlayer.fleets.add((Fleet)entitiesById.get(fleetId));
            }
            return restoredPlayer;
        }
    }
}