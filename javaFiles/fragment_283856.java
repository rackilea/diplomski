public void tryPlaceTile(int row, int column) {
    if (isValidMove(row, column) {
        addPlacedTile(row, column); // might update points
        if (tileStack.isEmpty()) {
            currentTile = null;
            endGame(); // stops the game, determines winner
        } else {
            currentTile = tileStack.pop();
            currentPlayerIndex = currentPlayerIndex == players.size() - 1 ? 0 : currentPlayerIndex + 1;
            updateView(); // likely not needed with data binding
        }
    } else {
        notifyUserOfInvalidMove();
    }

    // let method simply return, it will be called again when
    // the (next) player clicks in the appropriate place of
    // the view
}