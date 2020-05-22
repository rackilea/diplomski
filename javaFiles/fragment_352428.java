public class ClassVO implements Comparable {
....

    public int compareTo(ClassVO other) {
        return (this.getID().compareTo(other.getID()));
    }
}