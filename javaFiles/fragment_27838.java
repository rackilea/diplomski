public class MapObjectFactory {

    public MapObject create(int i) {
        if (i == 0)
            return new Door();
        if (i == 1)
            return new OtherSubClass();
        // etc, then a "default" in case above conditions not met
        return new MapObject();
    }
}