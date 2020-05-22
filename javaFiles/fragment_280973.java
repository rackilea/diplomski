public class Atom {
    public final int index;

    private Atom(int ix) {
        this.index = ix;
    }

    public String getDatum() {
        return null;
    }

    public static Atom createAtom(int index) {
        return index != 0 ? new Atom(index) : new ExtendedAtom(index);
    }
}

class ExtendedAtom extends Atom {
    private String datum;

    ExtendedAtom(int ix) {
        super(ix);
    }

    @Override
    public String getDatum() {
        return datum;
    }

}