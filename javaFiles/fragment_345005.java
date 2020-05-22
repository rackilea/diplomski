if (indexOfDeadGuy > -1) {
    Creature deadGuy = drawArray[indexOfDeadGuy];
    for (int i = indexOfDeadGuy; i > 0; i--) {
        drawArray[i] = drawArray[i - 1];
    }
    drawArray[0] = deadGuy;
}