@Override
public boolean touchDragged(int screenX, int screenY, int pointer) {
    tmp.x = screenX;
    tmp.y = (Gdx.graphics.getHeight() - screenY);
    tmp.z = 0;
    cam.unproject(tmp);
    grid.manipulateGrid((int)(tmp.x) / MapGrid.CELL_SIZE, (int)(tmp.y) / MapGrid.CELL_SIZE, false);
    System.out.println("Clicked at: (" + tmp.x / MapGrid.CELL_SIZE + ", " + tmp.y / MapGrid.CELL_SIZE +")");
    return false;
}