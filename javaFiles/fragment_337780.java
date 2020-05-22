public final class TravellersUtility {

    private TravellersUtility() { }

    public static Travellers merge(Travellers left, Travellers right) {
        Travellers t = new Travellers();
        t.setRouteId(left.getRouteId());
        t.setTravellerId(left.getTravellerId());
        t.setCame(left.getCame() + right.getCame());
        t.setGone(left.getGone() + right.getGone());
        return t;
    }
}