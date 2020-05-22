// Keep a reference to a listener that should be notified of events
private GameEventListener mListener;

// An interface defining events that a listener will receive
public interface GameEventListener {
    void onWin();
    void onLoss();
}

public void setGameEventListener(GameEventListener listener) {
    mListener = listener;
}

private void notifyGameWon() {
    if (mListener != null) {
        mListener.onWin();
    }
}

private void notifyGameLost() {
    if (mListener != null) {
        mListener.onLoss();
    }
}