public class AreaSurrogate implements Serializable {

    private final Rectangle bounds;

    public AreaSurrogate(Area area) {
        this.bounds = area.getBounds();
    }

    private Object readResolve() throws ObjectStreamException {
        return new Area(bounds);
    }
}