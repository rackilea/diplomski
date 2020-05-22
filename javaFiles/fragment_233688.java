public class HashComparative extends Observable implements Callable<String> {

    private String h;

    ...

    public void setHash(String h) {
        this.h = h;
        setChanged();
        notifyObservers();
    }

    public String getHash() {
        return h;
    }
}