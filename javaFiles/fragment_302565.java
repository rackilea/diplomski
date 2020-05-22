public class MyTileService extends TileService {
    public static boolean isAdded = false;

    //...

    @Override
    public void onTileAdded() {
        isAdded = true;
    }

    @Override
    public void onTileRemoved() {
        isAdded = false;
    }
}