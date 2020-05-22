public boolean freeWayHorizontally(int xO, int yO, int xD) {
    int destination = xD;
    int origin = xO + 1;
    if (xO > xD) {
        destination = xO - 1;
        origin = xD;
    }

    for (int x = origin; x < destination; x++) {
        CrazyPiece thereIsPiece = Simulador.pegaPecaPorCoordenada(x, yO);
        if (thereIsPiece != null){
            return false;
        }
    }

    return true;
}