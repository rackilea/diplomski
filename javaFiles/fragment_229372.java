private static final int LOSE_GAME_EVENT = 1;

private final Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case LOSE_GAME_EVENT:
                // Then the player has lost the game.
                break;
        }
    }
};