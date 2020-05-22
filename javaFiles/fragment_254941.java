public class Triple<A, B, C> {
    private final A mFirst;
    private final B mSecond;
    private final C mThird;

    public Triple(final A first, final B second, final C third) {
        this.mFirst = first;
        this.mSecond = second;
        this.mThird = third;
    }

    public A getFirst() {
        return this.mFirst;
    }

    public B getSecond() {
        return this.mSecond;
    }

    public C getThird() {
        return this.mThird;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.mFirst.hashCode();
        result = prime * result + this.mSecond.hashCode();
        result = prime * result + this.mThird.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Triple other = (Triple) obj;
        if (this.mFirst == null) {
            if (other.mFirst != null) {
                return false;
            }
        } else if (!this.mFirst.equals(other.mFirst)) {
            return false;
        }
        if (this.mSecond == null) {
            if (other.mSecond != null) {
                return false;
            }
        } else if (!this.mSecond.equals(other.mSecond)) {
            return false;
        }
        if (this.mThird == null) {
            if (other.mThird != null) {
                return false;
            }
        } else if (!this.mThird.equals(other.mThird)) {
            return false;
        }
        return true;
    }
}