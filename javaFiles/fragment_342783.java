public class BoidList extends ArrayList<Boid> {

    private void checkIndex(int idx) {
        if (idx >= super.size() || idx < 0) {
            throw new ArrayIndexOutOfBoundsException(String.valueOf(idx));
        }
    }

    synchronized public Boid getBoid(int idx) {
        checkIndex(idx);
        return super.get(idx);
    }

    synchronized public void removeBoid(int idx) {
        checkIndex(idx);
        super.remove(idx);
    }
}