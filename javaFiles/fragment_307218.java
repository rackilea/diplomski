private boolean alreadySeized = false;

public void applyPunishment() {
    if (alreadySeized) {
        return;
    }

    alreadySeized = true;