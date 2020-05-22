public abstract class MapObjects<MapleMapObject> implements Iterable<MapleMapObject> {

    ...

    @Override public Iterator<MapleMapObject> iterator() {
        return objects.values().iterator();
    }
}