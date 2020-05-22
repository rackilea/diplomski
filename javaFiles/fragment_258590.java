public class Pair {

    private final int value1;
    private final int value2;

    public Pair(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int value1() {
        return value1;
    }

    public int value2() {
        return value2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value1;
        result = prime * result + value2;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pair other = (Pair) obj;
        if (value1 != other.value1)
            return false;
        if (value2 != other.value2)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "(" + value1 + ", " + value2 + ")";
    }

}