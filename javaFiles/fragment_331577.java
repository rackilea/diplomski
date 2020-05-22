public class TowerOfHanoi<E> {
    private class Disk<T extends Comparable<E>> {
    }

    private class Peg<T extends Disk<Comparable<E>>> extends Stack<Disk<Comparable<E>>> {
    }
}