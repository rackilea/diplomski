public static void moveMouse(int x, int y, int maxTimes, Robot screenWin) {
    for(int count = 0;(MouseInfo.getPointerInfo().getLocation().getX() != x || 
            MouseInfo.getPointerInfo().getLocation().getY() != y) &&
            count < maxTimes; count++) {
        screenWin.mouseMove(x, y);
    }
}