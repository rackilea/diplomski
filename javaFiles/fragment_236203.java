public interface Hasher {
    int getHash(String s);
}

public class HashFunction {
    private Hasher f;
    public HashFunction(Hasher f) {
        this.f=f;
    }
    public Integer hash(String s){
        return f(s);
    }
}