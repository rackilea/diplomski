private static String checkGameState() {
    // Looking for errors.
    if (rowCount <= 0 || columnCount <= 0) {
        return "ERROR: Illegal board size: " + rowCount + "*" + columnCount;
    }
    if (boradContent.length != rowCount * columnCount) {
        return "ERROR: boradContent not compatible with rowSize and columnSize.";
    }
    if (sizeWin > rowCount && sizeWin > columnCount) {
        return "ERROR: Board is too small for this sizeWin: " + sizeWin + ".";
    }

    String gameState = "PLAYING";

    // Checking rows
    for (int i = 0; i < rowCount; i++) {
        char currentChar = getField(i, 0);
        int score = 1;
        for (int j = 1; j < columnCount; j++) {
            if (currentChar == getField(i, j)) {
                score++;
                if (score >= sizeWin) {
                    if (gameState.equals("PLAYING")) {
                        gameState = currentChar + "WIN";
                    } else if (!gameState.equals(currentChar + "WIN")) {
                        gameState = "DRAW";
                        return gameState;
                    }
                }
            } else {
                if (j > columnCount - sizeWin) {
                    break;
                }
                score = 1;
                currentChar = getField(i, j);
            }
        }
    }

    // Checking columns
    for (int j = 0; j < columnCount; j++) {
        char currentChar = getField(0, j);
        int score = 1;
        for (int i = 1; i < rowCount; i++) {
            if (currentChar == getField(i, j)) {
                score++;
                if (score >= sizeWin) {
                    if (gameState.equals("PLAYING")) {
                        gameState = currentChar + "WIN";
                    } else if (!gameState.equals(currentChar + "WIN")) {
                        gameState = "DRAW";
                        return gameState;
                    }
                }
            } else {
                if (j > rowCount - sizeWin) {
                    break;
                }
                score = 1;
                currentChar = getField(i, j);
            }
        }
    }

    // Checking diagonally
    // Checking diagonally - from top-left to bottom-right
    for (int i = 0; i < rowCount - sizeWin + 1; i++) {
        for (int j = 0; j < columnCount - sizeWin + 1; j++) {
            char currentChar = getField(i, j);
            int score = 1;
            for (int k = 1; k < sizeWin; k++) {
                if (currentChar == getField(i + k, j + k)) {
                    score++;
                    if (score >= sizeWin) {
                        if (gameState.equals("PLAYING")) {
                            gameState = currentChar + "WIN";
                        } else if (!gameState.equals(currentChar + "WIN")) {
                            gameState = "DRAW";
                            return gameState;
                        }
                    }
                } else {
                    break;
                }
            }

        }
    }

    // Checking diagonally - from top-right to bottom-left
    for (int i = 0; i < rowCount - sizeWin + 1; i++) {
        for (int j = sizeWin -1; j < columnCount; j++) {
            char currentChar = getField(i, j);
            int score = 1;
            for (int k = 1; k < sizeWin; k++) {
                if (currentChar == getField(i + k, j - k)) {
                    score++;
                    if (score >= sizeWin) {
                        if (gameState.equals("PLAYING")) {
                            gameState = currentChar + "WIN";
                        } else if (!gameState.equals(currentChar + "WIN")) {
                            gameState = "DRAW";
                            return gameState;
                        }
                    }
                } else {
                    break;
                }
            }

        }
    }

    return gameState;
}