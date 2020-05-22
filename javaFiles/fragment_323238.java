public abstract class Animal<T extends Animal> {

    public abstract void fetch(T ani);
}

public class GoldenRetriever extends Animal<GoldenRetriever> {

    @Override
    public void fetch(GoldenRetriever ani) {

    }
}