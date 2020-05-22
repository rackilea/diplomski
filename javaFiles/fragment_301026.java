public class OSDHolder implements Comparable<OSDHolder> {

    private final OSD obj;

    public OSDHolder(OSD obj) {
        this.obj = obj;
    }

    public long getTiming() {
        this.obj.getUpdatedOn().getTime();
    }

    @Override
    public int compareTo(OSDHolder o) {
        if (this.getTiming() > o.getTiming())
            return 1;
        else if (this.getTiming < o.getTiming())
            return -1;
        return 0;
    }
}