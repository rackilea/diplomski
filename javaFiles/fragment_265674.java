public class GameObject implements Comparable<GameObject> {
    // ...

    @Override
    public int compareTo(GameObject that) {
        return this.getLayer().compareTo(that.getLayer());
    }
}

Arrays.sort(gameobj);