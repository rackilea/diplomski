public enum PlayerTypes {
    GOOD { 
        @Override
        protected PlayerType newPlayer() { 
            return new GoodPlayer();
        }
    }, 
    BAD {
        @Override
        protected PlayerType newPlayer() { 
            return new BadPlayer();
        }
    },
    RANDOM {
        @Override
        protected PlayerType newPlayer() { 
            return new RandomPlayer();
        }
    };

    protected abstract PlayerType newPlayer();

    public static PlayerType create(String input) {
        for(PlayerTypes player : PlayerTypes.values()) {
             if(player.name().equalsIgnoreCase(input)) {
                 return player.newPlayer();
             }
        }
        throw new IllegalArgumentException("Invalid player type [" + input + "]");
    }
)